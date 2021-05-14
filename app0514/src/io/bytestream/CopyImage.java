package io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyImage{
	FileInputStream fis;
	FileOutputStream fos;
	
	public CopyImage(){
		try {
			fis = new FileInputStream("D:\\workspace\\korea202102_javaworkspace\\app0514\\res\\dog.jpg");
			fos = new FileOutputStream("D:\\workspace\\korea202102_javaworkspace\\app0514\\res\\dog_copy.jpg");
			//입력스트림으로는 데이터의 1바이트씩 읽어들이고, 출력스트림으로는 데이터 1바이트씩 출력해보자!!(복사)
			int data=-1;
			while(true) {
				data = fis.read(); //1byte 읽기(입력)
				
				//System.out.println(data);
				
				if(data==-1)break;
				fos.write(data); //1byte 쓰기(출력)
			}
			System.out.println("복사 완료!!");
			//스트림은 반드시 닫아야 한다
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 읽을 수 없습니다");
		}finally {
			//아래의 코드는 객체의 생성이 성공했을때만..수행하라..
			if(fis !=null) { //즉 객체가 존재할때만..
				try {
					fis.close(); //스트림을 닫을때도  IO예외가 발생할수 있다고  sun 에서 정했다..따라주자..
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos !=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args){
		new CopyImage();
	}
}
