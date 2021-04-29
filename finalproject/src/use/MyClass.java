class MyClass{
	public static void main(String[] args){
		int  a=7;        //(가)
		//int  a=3;       //(나) 
		{
			int a=3;     //(다)
		}
		{
			a=5;        //(라)
		}
		System.out.println(a); //(마)
	}
}
