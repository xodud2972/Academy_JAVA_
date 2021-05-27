package app0527.network.uni.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//에코서버는 접속자마다 소켓을 유지할수 없기에, 아래의 클래스를 정의하여, 인스턴스변수로 보관하고,
//이 소켓을 통한 클라이언트와의 메시지 송수신을 , 아래의 클래스로부터 생성되는 인스턴스가 각각 독립적으로
//실행할 수 있도록 쓰레드로 구현해보자!!
public class ServerMsgThread extends Thread{
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	JTextArea area;
	
	public ServerMsgThread(Socket socket, JTextArea area) {
		this.socket=socket;
		this.area=area;
		
		try {
			//소켓으로부터 2가닥의 실(입력, 출력스트림)을 뽑아놓자!!
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고 : 입력
	public void listen() {
		String msg=null; 
		try {
			msg=buffr.readLine();
			send(msg);
			area.append(msg+"\n");//서버로그에 메시지 남기기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//말하고 : 출력
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트와 끝없는 대화를 나눌 수 있도록 구현할 예정..
	public void run() {
		while(true) {
			listen();
		}
	}
}









