package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImage{
	FileInputStream fis;
	FileOutputStream fos;

	public CopyImage(){
		try{
			fis = new FileInputStream("D:/korea202102_javaworkspace/app0514/res/1.jpg");
			fos = new FileOutputStream("D:/korea202102_javaworkspace/app0514/res/1_copy.jpg");

			int data = -1;
			while(true){
				data = fis.read(); 
				if(data == -1) break; 
				fos.write(data);
			}
			fis.close();
			fos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("파일을 읽을 수 없습니다.");
		}finally {
			//아래의 코드는 객체의 생성이 성골했을 떄만 수행하라
			if(fis != null) {
				try {
					fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
			if(fos != null) {
				try {
					fos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
	}
	}

	public static void main(String[] args){
		new CopyImage();
	}
}
