package app0602.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;





// 키보드로부터, 문자를 입력받아 모니터에 출력하도, 한글이 깨지지 않아야 하고,
// 한줄씩 입력받아, 한줄 씩 출력하시오
public class BufferTest {
	public static void main(String[] args) {
		InputStream is = System.in;
		
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffr = new BufferedReader(reader);
		
		String data = null;
		
		while(true) {
			try {
				data =buffr.readLine();
				System.out.println(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
