package animal.birds;

class UseDuck{

	public static void main(String[] args){
		//���� �Ѹ����� �޸𸮿� �ø���, (�ν��Ͻ� ����) canSwim �޼��带 ȣ���غ���
		Duck d = new Duck("white");
		d.canSwim();

		Bird b = new Bird();
		b=d; //����?  �Ұ���?
		
		//byte  short  int   long : �������� ���� ���� ������ �ڷ����̴�!!!
		//�� ���� ������ �ڷ��� �̱⿡ ���� ����ȯ�� �����ϴ�!!
		byte b=5;
		int k=b;

		//��ü���� �ڷ����̴�...
		


	}
}