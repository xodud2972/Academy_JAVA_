package api;
class StringTest2{
	public static void main(String[] args) {
		//String�� ��ü������, �ʹ��� ���� ���̱� ������ ��ġ �⺻�ڷ��� ó�� ��ü�� �����ϴ� �����
		//�����Ѵ�..�� �Ʒ��� ����..
		//�Ͻ���(=������)������  , implicit �������̶� �Ѵ�
		String str1="apple";	//������ ��ü��~~
		String str2="apple";
		System.out.println(str1==str2); //�ּҰ� ��������, ���� �ּҸ� ����Ű�Ƿ� ��ġ �����ó��
														//����� true �� �ȴ�..	
		
		//String�� Ŭ���� �̹Ƿ�, �̹����� �����ڸ� �̿��غ��� 
		//�����(explicit) ������
		String s1=new String("korea");
		String s2=new String("korea");
		System.out.println(s1==s2); // ����� ���������� String ��ü�� �����ϸ� ȿ���� ���θ� ������
													//�ʰ� �Ǽ�  constant pool�� ��������� �ʴ´�..���� s1,s2
													//����Ű�� �ִ� ��ü�� �ν��Ͻ��� �ٸ��Ƿ�, ����� false��

	}
}
