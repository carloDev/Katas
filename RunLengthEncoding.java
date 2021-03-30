package codekatas;

import java.util.LinkedList;

public class RunLengthEncoding {

	public static void main(String[] args) {

		// Output: [(“a”,4), (“b”,3), (“c”,2), (“a”,1)]
		// List<String> paroleTrovate
		RunLengthEncoding r = new RunLengthEncoding();
		String in = "aaaabbbcca";
		String tmp = "";
		LinkedList<Sequenza> occorrenzeList = new LinkedList<Sequenza>();
		int occorrenze = 0;
		RunLengthEncoding.Sequenza seq = null;
		for (int i = 0; i < in.length(); i++) {
			String charAt = in.charAt(i) + "";

			if (tmp.trim().length() == 0) {
				occorrenze++;
				seq = r.new Sequenza();
				seq.setLettera(charAt);
				seq.setOccorrenza(occorrenze);
				occorrenzeList.add(seq);
			}
			
			if (tmp.trim().length() > 0 && charAt.equals(tmp)) {
				occorrenze++;
				occorrenzeList.getLast().setOccorrenza(occorrenze);
			}

			if (tmp.trim().length() > 0 && !charAt.equals(tmp)) {
				occorrenze = 0;
				occorrenze++;
				seq = r.new Sequenza();
				seq.setLettera(charAt);
				seq.setOccorrenza(occorrenze);
				occorrenzeList.add(seq);
			}
			tmp = charAt;
		}
		System.out.println(occorrenzeList);
	}

	public class Sequenza {

		String lettera;
		int occorrenza;

		public String getLettera() {
			return lettera;
		}

		public void setLettera(String lettera) {
			this.lettera = lettera;
		}

		public int getOccorrenza() {
			return occorrenza;
		}

		public void setOccorrenza(int occorrenza) {
			this.occorrenza = occorrenza;
		}

		@Override
		public String toString() {
			return "Sequenza [lettera=" + lettera + ", occorrenza=" + occorrenza + "]";
		}
	}

}
