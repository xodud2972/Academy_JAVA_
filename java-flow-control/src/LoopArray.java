
public class LoopArray {

	public static void main(String[] args) {
		/*
		 *  <li>taeyoung</li>
		 *  <li>juho</li>
		 *  <li>daeho</li>
		 *  */
		
		String[] users = new String[3];
		users[0] = "taeyoung";
		users[1] = "juho";
		users[2] = "daeho"; 
		
		for(int i=0; i<users.length; i++) {
			System.out.println("<li>"+users[i]+"</li>");
		}
	}
}
