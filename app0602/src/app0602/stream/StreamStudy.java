package app0602.stream;

import java.io.IOException;
import java.io.InputStream;

public class StreamStudy {
	
	public static void main(String[] args) {
		// System.out.println("야호~"); // 어디로 출력 되나?? 표준스트림으로 처리 됨..
		
		// 키보드를 통해 데이터를 입력받아보자.
		//FileInputStream fis = new ~~ 파일스트림은 생성시점을 개발자가 정할 수 있는 스트림이다.
		//하지만 키보드, 모니터, 바코드 스캐너, 프린터기 등등 은 하드웨어를 시스템인 OS가 관리하므로,
		//컴퓨터를 키는 순간부터 이미 스트림은 존재하게 된다. 따라서 new가 아닌, 시스템인 os로 부터 얻을 수 있고,
		//자바에서 이 os 인 시스템을 접근할 때 사용되는 객체가 바로 System 이다.
		InputStream is = System.in;
		
		// 현재 is 는 바이트 기반으므로, ibyte씩 처리할 수 있다.
		int data = -1;
		
		while(true) {
			try {
				data = is.read();
				System.out.println((char)data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
