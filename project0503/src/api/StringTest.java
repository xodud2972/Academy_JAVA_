/*
���ݱ����� �츮�� ������ Ŭ���� ���ַ� �н��� �ؿԴ�..������, ���� ���߽�
�̹� sun���� �����ϴ� ������ Ŭ�������� �ַ� Ȱ���ϰ� �ȴ�...
�̹� �ð��� sun���� �����ϴ� ���� Ŭ���� �� ���ڿ� ó���� �߿��� ����� ����ϴ� 
String Ŭ������ ���� �н��غ���!!
*/
package api;

class StringTest{
	public static void main(String[] args) {
		//String�� ����  import������ �����Ƿ�, ������ ���� ������ 
		//��� �ʹ��� ���� ���Ǵ� �� ������ Ŭ�������� �����ڰ� ������� �ʾƵ� 
		//�̹� �⺻������ import �Ǿ� �ִ�.. java.lang ��Ű���� �ٷ� �װ��̴�!!!
		String s=new String("apple");//�����ε� �� ���� ������ �� �ϳ��� .. 
		// string Ŭ������ api document �� �̿��Ͽ�, �����ڴ� ���� ��ɵ��� ������ �� �ִ�..

		//���ڿ��� ���̸� �˼��ִ� api  ���� ��ũ 
		System.out.println("���ڿ��� ���̴� "+s.length());

		//�빮�ڷ� ��ȯ�ϴ� �޼��� api���� ��ũ 
		System.out.println(s.toUpperCase());
		
		//�ι�°p�� index�� ��ȯ�ϴ� api���� ��ũ 
		System.out.println("������ p�� index�� "+s.lastIndexOf("p"));

		//���ϴ� ��°�� �ִ� ���� 1���� �����ϴ� api���� ��ũ 
		System.out.println(" chatAt�� ��� "+s.charAt(4));

	}
}
