package codekatas;

/**
 * https://programmingpraxis.com/2021/01/26/tax-brackets/ 
 * 
 */
public class TaxBrackets {

	public static void main(String[] args) {

		double income = 123456;
		double calculateTax = calculateTax(income);
		System.out.println(calculateTax);
	}

	private static double calculateTax(double income) {
		double totalTax = 0;
		double import1 = 10000;
		double import2 = 30000;
		double import3 = 100000;
		
		if (income <= import1) {
			return totalTax;
		}
		
		if (income > import1 && income <= import2) {
			income = income - import1;
			totalTax = (income * 10) / 100;
			return totalTax;
		}
		
		if (income > import2 && income <= import3) {
			income = income - import2;
			totalTax = ((income * 25) / 100) + 2000;
			return totalTax;
		}
		
		if (income > import3) {
			income = income - import3;
			totalTax = ((income * 40) / 100) + 2000 + 17500;
			return totalTax;
		}
		
		return totalTax;
	}
	
}
