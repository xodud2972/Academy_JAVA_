/*
�������� �ڹ����α׷����� �޸��� ������ ������ �о���� = �Է�
�ڹ��� java.io ��Ű���� io ���� Ŭ������ ����
*/
package io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadMemo{
	FileInputStream fis; // �Է½�Ʈ�� �� ������ ������� �� �Է½�Ʈ��
	FileOutputStream fos; // ��½�Ʈ�� �� ������ ������� �� ��½�Ʈ��
	
	public ReadMemo(){

		// �ڹٿ��� ���������� ������ ���ٸ�, �����α׷��� ������ �����ϰ� ������ ����ȴ�. (Ʋ����)
		// �Ʒ��� �ڵ�� ���������δ� ������ ������, ���� �����ڰ� ���ϸ��� �߸������� ���,
		// ������ �� ( �� runtime �� ) ������ �߻��Ͽ�, ���α׷��� ���������ᰡ �Ǿ� ������.
		// ����ó�� ���� ? ������ ������ ���� ����
		try{
			fis = new FileInputStream("D:/korea202102_javaworkspace/app0514/res/memo.txt");
			System.out.println("���Ͽ� ���� ��Ʈ�� ���� ����");

			fos = new FileOutputStream("D:/korea202102_javaworkspace/app0514/res/memo.txt");

			//���� ������ ���������Ƿ�, ��� �ڿ����κ��� �����͸� 1byte �� ���̸�����
			while(true){
				int data = fis.read(); // 1byte �о�帲
				if(data == -1) break; //������ ��쿡�� �극�̽�{} ������ �����ϴ�.
				fos.write(data);
				System.out.print((char)data);
			}

		} catch(FileNotFoundException e){
			// ���� try�� ������ �����ߴ� ����� �߻��� ���, ���α׷��� ���������� �Ǵ� �Ž� �ƴ϶�
			// ����ΰ� �� catch ������ �����ϰ� �ȴ�. �׷� ���⼭ ���� �ؾ��ϳ�?
			// ������ ������ ã�Ƴ� �� �ִ� �α�, ����ڿ��� ����(�̸���, sns, ��), �ȳ��޽��� 
			System.out.println("�ش� ������ ã�� �� �����ϴ�");
		} catch(IOException e){
			System.out.println("���� �б� ����");
		}
	}

	public static void main(String[] args){
		new ReadMemo();		
	}
}
