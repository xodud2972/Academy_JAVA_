package io.charstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadText {
	FileInputStream fis;
	
	public ReadText() {
		try {
			fis = new FileInputStream("D:\\korea202102_javaworkspace\\app0514\\res\\dirary.txt");
			int data = -1;
			try {

				data = fis.read();
				System.out.print((char)data);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ReadText();
	}
}
