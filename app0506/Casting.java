
public class Casting {

	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1;
		double b2 = (double) 1; // 위에 변수 b는 int이지만 double로 해도 에러가 나지 않는다.
											//  대신 1 이 아닌 1.0으로 출력된다.
		
		System.out.println(b2);

		// int c = 1.1;
		double d = 1.1; // int가 1.1에 type에 맞게 자동으로 double로 바뀐다.
		int e = (int) 1.1; // 원래는 double 이지만 강제로 int형으로 바꾼것이다.
		System.out.println(e); //강제로 데이터타입을 바꾸는 것을 casting이라고 한다.
		
		// 1 to String 
		String f = Integer.toString(1); // 정수(int)인 1을 문자(String)으로 바꾼다.
		System.out.println(f.getClass()); //어떤 데이터 타입인지 확인 할 수 있는 getClass
		
	}

}
