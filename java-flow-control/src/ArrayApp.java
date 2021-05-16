
public class ArrayApp {

	
	public static void main(String[] args) {
		
		// taeyoung, juho, daeho
		//String users = "taeyoung, juho, daeho";
		String[] users = new String[3];
		users[0] = "taeyoung";
		users[1] = "juho";
		users[2] = "daeho";
		
		System.out.println(users[0]);
		System.out.println(users[1]);
		System.out.println(users[2]);
		System.out.println(users.length);
		
		// 한 번에 배열을 생성하고 값을 집어 넣는 방법
		int[] scores = {10, 100, 100};
		System.out.println(scores[1]);
		System.out.println(scores.length);
		
		
	}
}
