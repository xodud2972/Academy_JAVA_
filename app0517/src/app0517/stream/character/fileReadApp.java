package app0517.stream.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 문자기반 스트림을 학습하면서 동시에 효율적으로 데이터를 처리하는 법에 대해 알아보자 */
public class fileReadApp {
	FileReader reader;
	BufferedReader buffr;
	File file;
	String path = "D:\\korea202102_javaworkspace\\app0517\\res\\자바13일차.txt";
	public fileReadApp() {
		try {
			reader = new FileReader(file = new File(path)); // 파일을 대상으로 빨대를 꽂음
			buffr = new BufferedReader(reader); // 기존의 FileReader를 버퍼러처리된 리퍼로 업그레이드
			
			String data = null;
			while(true) {
				data = buffr.readLine(); // 한 줄을 읽어들인다. 따라서 반환형은 문자열이다.
				if(data == null) break; // 파일의 끝을 만나면 -1반환하므로, 반복문 멈추기!
				System.out.print(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new fileReadApp();
	}
}


