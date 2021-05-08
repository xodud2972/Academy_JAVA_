
public class AccountingClassApp {

	public static double valueOfSupply; // 전역변수로 지정
	public static double vatRate; // getVAT메소드를 위해서 전역변수로 지정 
	public static double expenseRate;
	
	public static void main(String[] args) {
		
		valueOfSupply = 10000.0;
		vatRate = 0.1;
		expenseRate = 0.3;		
		print();
		// anotherVariable = ...;
		// anotherMethod = ...;
	}

	private static void print() {
		System.out.println("Value of supply : "+valueOfSupply);
		System.out.println("VAT : "+ getVAT()	);
		System.out.println("Total : "+ getTotal()		);
		System.out.println("Expense : "+ getExpense()		);
		System.out.println("Income : "+ getIncome()		);
		System.out.println("Dividend : "+ getDividend1()	);
		System.out.println("Dividend : "+ getDividend2()	);
		System.out.println("Dividend : "+ getDividend3()	);
	}

 static double getDividend3( ) {
		return getIncome() * 0.2;
	}

 static double getDividend2( ) {
		return getIncome() * 0.3;
	}

 static double getDividend1( ) {
		return getIncome() * 0.5;
	}

	private static double getIncome( ) {
		return valueOfSupply - getExpense();
	}

	private static double getExpense() {
		return valueOfSupply * expenseRate;
	}

	private static double getTotal() {
		return valueOfSupply + getVAT();
	}

	private static double getVAT() {
		return valueOfSupply * vatRate;
	}

}
