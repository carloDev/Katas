package codekatas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AnimalFood {

	class Animal implements Comparable<Animal>{

		public Animal() {
			food = new TreeSet<String>();
		}

		String name;
		TreeSet<String> food;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public TreeSet<String> getFood() {
			return food;
		}

		public void setFood(TreeSet<String> food) {
			this.food = food;
		}

		@Override
		public String toString() {
			return "Animal [name=" + name + ", food=" + food + "]";
		}

		public int compareTo(Animal o) {
			return this.name.compareTo(o.getName());
//			return 0;
		}
	}

	public static void main(String[] args) {

		try {

			AnimalFood outerObject = new AnimalFood();
			TreeSet<Animal> animals = new TreeSet<Animal>();
			AnimalFood.Animal innerObject = null;

			FileReader fw = new FileReader(
					"D:\\WORK\\workspace\\code_kata\\codekatas\\src\\main\\resources\\input\\Animal.txt");
			int data = fw.read();
			StringBuilder readed = new StringBuilder();
			String checkAnimal = "There once was a ";
			String ate = " he ate ";
			while (data != -1) {
				readed.append((char) data);
				data = fw.read();
			}
			fw.close();

			String[] lines = readed.toString().split("\\r?\\n");
			for (String line : lines) {
				if (line.toString().contains(checkAnimal)) {
					String[] split = line.split(checkAnimal);
					innerObject = outerObject.new Animal();
					innerObject.setName(split[1].trim());
					animals.add(innerObject);
				}
				if (line.contains(ate)) {
					String food = line.split(ate)[1];
					innerObject.food.add(food.trim());

				}
			}

			TreeSet<String> fruits = new TreeSet<String>();
			for (Animal row : animals) {
				fruits.addAll(row.getFood());
			}

			for (String fruit : fruits) {
				System.out.println("Food: " + fruit + " Animals who ate it: " + count(animals, fruit));
				System.out.println("========");
				printAnimal(animals, fruit);
				System.out.println("");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int count(TreeSet<Animal> animals, String fruit) {
		int result = 0;
		for (Animal animal : animals) {
			if (animal.getFood().contains(fruit)) {
				result++;
			}
		}
		return result;
	}

	private static int printAnimal(TreeSet<Animal> animals, String fruit) {
		int result = 0;
		for (Animal animal : animals) {
			if (animal.getFood().contains(fruit)) {
				System.out.println(animal.getName());
			}
		}
		return result;
	}
}
