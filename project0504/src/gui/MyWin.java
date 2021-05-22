/*GUI ���α׷����� ������ �����찡 �־�� �Ѵ�..
���� �ڹ� ���� GUI���õ� ��Ű���� awt/swing���� ���� 
javaFX ( �ȵ���̵�� ���� ��� )
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Choice;

public class MyWin{
	//�ڹٿ��� ������� ���������� Frame�̶�� Ŭ������ ���	
	public static void main(String[] args){
		Frame frame; //��ü�� �ν��Ͻ� ����. ���� frame���� �ʱ�ȭ�Ǿ� ���� �ʴ�!!

		/*Frame�̶�� Ŭ������ ����� �������ذ��ε�, ������ ��� ����ؾ����� ������..
		��?? �츮�� ������ Ŭ������ �ƴϹǷ�..�� ���� �������ذ��̹Ƿ�...
		[ ������ �������� ��ü ����ϴ� Tip ]
			1) �ش� Ŭ������ ����ü ����? �뵵�� ����? �������� ����?
			
			2) ���� ���ؼ��� �޸𸮿� �÷��� �Ѵ�
			    �޸𸮿� �ø�����, �� ��ü�� �Ϲ�����, �߻�����, �������̽� �������� ����!!
				- �Ϲ�Ŭ������ ���: new �ϸ� �ȴ�!!
				- �߻�Ŭ������ ���: �ڽ����� �ϼ� ��, �ڽ��� new�ϸ� �� 
				- �������̽��� ���: �ڽ����� �ϼ� ��, �ڽ��� new�ϸ� �� 
			
			3) ��ü�� ������ �����Ǿ��ٸ�
				- �Ϲ�Ŭ������ ��쿣 new ������ �;� �ϴ� �����ڸ� ����
		*/
		frame = new Frame(); //�������� �⺻������ ���� ������ �ʵ��� �Ӽ��� �����Ǿ� �ִ�..
			

		Button bt=new Button("me");

		//��ư ������, ��չ�ư�� ������ ����?  
		//��� GUI���α׷��� ������ ȭ���� ��ġ ����� �����ڰ� �����ؾ� �Ѵ�..
		//html���� absolute, relative�� �ֵ�.. GUI �������α׷��� ������ ���� ��ٷӰ� �����ϴ� 
		//���� �츮�� �ƹ��� ��ġ(Layout)�� �������� �ʾұ� ������ �ý����� �����ϴ� ����Ʈ ��ġ�� ����
		//�Ǿ� ���ϴ� ȿ���� ������ ���� ����... 
		FlowLayout flow = new FlowLayout(); //������Ʈ�� �������� ��ġ�ϴ� ���̾ƿ� ��ü 
		//�� �������� ��������, �������� ���������� ������...
		frame.setLayout(flow); //�����ӿ� ��ġ������ ����!!


		//�Է��ؽ�Ʈ �ڽ� �����Ͽ� �����ӿ� �ٿ�����!!! 
		TextField t=new TextField(20); //20�ڸ� ������ �ִٴ� ���� �ƴ϶�, 20�� ũ���� �ʺ� Ȯ����
		
		//üũ�ڽ� ������ 
		Checkbox ch1=new Checkbox("��ȭ");
		Checkbox ch2=new Checkbox("���α׷���");
		Checkbox ch3=new Checkbox("����");
		Checkbox ch4=new Checkbox("����");
		
		//TextArea 
		TextArea area=new TextArea(5, 15); //5��¥��

		//html �� select �ڽ��� java ������ Choice��� �Ѵ�
		Choice choice=new Choice();  // naver, google, daum 
		choice.add("Choose Your Email");
		choice.add("naver.com");
		choice.add("gmail.com");
		choice.add("daum.net");

		//password 
		

		frame.add(bt);//�����ӿ� ��ư ���� 
		frame.add(t); //�����ӿ� �ؽ�Ʈ�ʵ� ����
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);
		frame.add(area);
		frame.add(choice);

		//���� �����ڰ� ���ϴ� Ÿ�ӿ�, ���� ���ϼ� �ֵ��� �Ӽ��� �����ϴ� �޼��带 ȣ���غ���!!
		//api document ���� ã�ƺ���!
		frame.setVisible(true);//�ƹ����� Window Ŭ�������� �������� �޼���

		//ũ�⵵ ������� ������, ���ϴ� ũ��� �����찡 ������ ���� 
		frame.setSize(300,400);//�ƹ����� Window Ŭ�������� �������� �޼���
	}

}
