package api;

public class StringTest3{
	public static void main(String[] args){
		String s1="korea";
		String s2="korea";
		System.out.println(s1==s2); //s1,s2�� ���۷��� �����̱⿡, �񱳿�����
													//��  ������ �ּҰ��� ���ϰ� �ȴ�..
		//�׷��ٸ� ������ ���Ϸ���??? 
		boolean result = s1.equals(s2);  //s1�� s2�� ������ ������? 
		System.out.println("�� ���ڿ��� ���� �� ����� "+result);
	}
}