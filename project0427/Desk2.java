public class Desk2 {
	int x=9;
	static int y=3;
	



	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	static { //B  , Ŭ������ �ε�ɶ� �����Ѵ�!! �� ����� ����� �����Ѵ�!! 
				//main�޼��� ȣ��� ������!!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C �޸� �ö������ ����, static �������� ���۷�������
		//���� x�� �����Ҽ��� ����...
		int a=new Desk2().x; //D
		System.out.println(a); //E
		System.out.println(y); //F 
		
	}
}
