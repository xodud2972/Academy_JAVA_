package bank;
class Friend{
	public static  void main(String[] args){
		Account acc = new Account();
		System.out.println("ģ���� ���� �� �ܰ�� "+acc.getBalance());
		//acc.balance=acc.balance+8000;
		//������ ����, ���������� ��������, �޼��� ȣ��� �����͸� �����غ���
		acc.setBalance(150000);
	
		System.out.println("ģ���� ���� �� �ܰ�� "+acc.getBalance());


		//���� Friend Ŭ������ Account�� ���� ��Ű���� �����Ƿ�, Account�� ������
		//default ���������� �ɷ� �ִ� ��� ������ ����� ������ �����ϴ�!!!
		System.out.println("����� : "+acc.bankName);
		System.out.println("������ : "+acc.master);
		System.out.println("���¹�ȣ : "+acc.num);
	}	
}