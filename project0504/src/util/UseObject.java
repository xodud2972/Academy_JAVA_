package util;
class UseObject{
	public static void main(String[] args){
		ObjectTest ot = new ObjectTest();
		String str="monkey";

		//ot.test(); //�������� �ʴ� �޼��� ȣ��
		boolean result = ot.equals(str);
		System.out.println(ot); //ot �� ��ü�̹Ƿ�, ���ڿ��� �ƴϴ�. ������ System.out.println() 
		//���� ����� �õ��Ҷ�, ���ڿ�ȭ �Ǿ� �� �ּҰ����� ��ȯ��..
		//�츮�� toString() �޼ҵ带 ȣ���� ���� ����..�� ���ڿ�ȭ�ɶ� ObjectŬ�����κ��� ��ӹ��� 
		//toString() �޼��尡 �ڵ����� ȣ��Ȱ��̴�..

		//�����ڵ忡�� equals() �޼���� ObjectTest
		//Ŭ�������� ���� ���������� ����!! �׷����� �ұ�
		//�ϰ� ������ �߻����� �ʴ� ������? �ý��ۿ� ����
		//�̹� �����ϰ� �ִٴ� ����...
		//����: �����ڰ� ������� �ʴ��� �ڹپ���� �ֻ��� ����� Ŭ������ Object Ŭ�����κ���
		//��� ���� �����̱⿡...
		
	}
}
