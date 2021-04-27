int x=5; //전역 변수 인정 X
class Phone{
	int price=5000;
	String name="G21";
	static String company="Samsung";

	public void ring(){
		System.out.println("벨이 울려요");
	}

	public static void main(String[] args){
		Phone p1 = new Phone();
	}	
}
