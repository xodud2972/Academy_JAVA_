
public class AccountingAppIFUnder10000 {

	public static void main(String[] args) {
		
		double valueOfSupply = Double.parseDouble(args[0]); // stirng형으로 설정되어있는 args를 강제로 double형으로 변환시킨다.
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply * vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		double dividend1 = income * 1;
		double dividend2 = income * 0;
		double dividend3 = income * 0;
		
		System.out.println("Value of supply : "+valueOfSupply);
		System.out.println("VAT : "+ vat	);
		System.out.println("Total : "+ total		);
		System.out.println("Expense : "+ expense		);
		System.out.println("Income : "+ income		);
		System.out.println("Dividend : "+ dividend1	);
		System.out.println("Dividend : "+ dividend2	);
		System.out.println("Dividend : "+ dividend3	);
		
		
	}

}