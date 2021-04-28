package use;
import traffic.Bike; // traffic 이전 디렉토리 경로는 클래스패스(환경변수)에서 참조한다.
class UseBike{
	public static void main(String[] argss){
		Bike b = new Bike();

		b.run();
	}
}