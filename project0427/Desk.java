public class Desk {
	int x=0;
	static int y;
	
	//���� �ݺ����� �����Ͽ� �ڵ带 �����ϰ� �ʹٸ�? ���� ����� �ִ�..
	//�ν��Ͻ� �ʱ�ȭ ��
	//�� Ŭ������ Desk�κ��� �ν��Ͻ��� ������ ������ , �Ʒ��� �ڵ尡 ����
	//static ���̸�: static �ʱ�ȭ ��
	/*
	1) �ν��Ͻ� �ʱ�ȭ ��: �ش��ν��Ͻ��� �����ɶ� �����ϴ� �ڵ� ����
								  �������� ���Ұ� ���...
	2)  static �ʱ�ȭ ��: ���������� �ʱ�ȭ ���� ����	
	*/
	static{
		for(int i=1;i<=10;i++){
			x+=i;
		}
	}







	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { //B
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		System.out.println(x); //C
		int a=new Desk().x; //D
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}
