/*
�������� �ڹ����α׷����� �޸��� ������ ������ �о����=�Է�
�ڹ��� java.io ��Ű���� io���� Ŭ������ ����
*/
package io.bytestream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadMemo{
	FileInputStream fis; //�Է½�Ʈ�� �� ������ ������� �� �Է½�Ʈ�� 
	FileOutputStream fos;//��½�Ʈ�� �� ������ ������� �� ��½�Ʈ��

	public ReadMemo(){
		//�ڹٿ��� ���������� ������ ���ٸ�, �� ���α׷��� ������ �����ϰ� ������ ����ȴ�!!
		//�Ʒ��� �ڵ�� ���������δ� ������ ������, ���� �����ڰ� ���ϸ��� �߸������� ���, 
		//�����Ҷ�(�� runtime ��) ������ �߻��Ͽ�, ���α׷��� ���������ᰡ �� ������..
		//����ó���� ����? ������������ ����!!
		try{
			fis = new FileInputStream("D:/workspace/korea202102_javaworkspace/app0514/res/memo.txt");	
			System.out.println("���Ͽ� ���� ��Ʈ�� ���� ����!!!");

			fos = new FileOutputStream("D:/workspace/korea202102_javaworkspace/app0514/res/memo_copy.txt");

			//���� ������ ���������Ƿ�, ��� �ڿ����κ��� �����͸� 1byte�� ���̸�����!!!
			while(true){
				int data=fis.read(); //1byte �о����!!
				if(data==-1)break;		
				fos.write(data);
				System.out.print((char)data);
			}
			
		}catch(FileNotFoundException e){
			//���� try�������� �����ߴ� ����� �߻��� ���, ���α׷��� ����������Ǵ� ���� �ƴ϶�, 
			//����ΰ� �� catch ������ �����ϰ� �ȴ�.. �׷� ���⼭ ���� �ؾ��ϳ�?
			//������ ������ ã�Ƴ��� �ִ� �α�, ����ڿ��� ����(�̸���, sms, ��), �ȳ��޽���..
			System.out.println("�ش� ������ ã���� �����ϴ�");
		}catch(IOException e){
			System.out.println("���� �б� ����");
		}

	}

	public static void main(String[] args){
		new ReadMemo();
	}
}
