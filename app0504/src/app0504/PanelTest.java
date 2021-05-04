package app0504;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelTest {

	public static void main(String[] args) {
		// 그래픽 api 중 panel 을 학습. 판넬 == 판자때기
		Frame frame = new Frame("Panel Test");
		
		//아래 처럼, 인스턴스 자체를 넣는 경우는 ? 굳이 BorderLayout 이라는 객체의 래퍼런스가
		// 사용할 필요가 없는 경우, 즉 1회성일 때 변수는 필요가 없을수도 있음.
		// BorderLayout layout = new BorderLayout(); 이게 귀찮아서 아래처럼 serLayout안에  new로 넣어버린다.
		
		frame.setLayout(new BorderLayout());
		Button bt = new Button("I'm button");
		// frame.add(bt); // 개발자가 Border의 5가지 방향 중 선택하지 않았을 경우 Default 방향은 ? Center
		// 결론 : 버튼은 혼자만 존재하기 때문에 북, 동 ,서 ,남, 북 범위를 혼자 독차지 한다. 따라서 , 대왕 버튼이 등장한다.
		
		Panel p = new Panel(); //컴포넌트 중 말 뜻 그대로 무언가를 올려 놓을 수 있는 패널을 의미
		// 패널은 Container의 자식이므로, 다른 컴포넌트들을 포함할 수 있는 능력이 있고, 또한 Container 이기에
		// 배치관리자도 사용가능하다.
		// 왕버튼에 대한 해결책? Frame 에 Panel을 부착하고, 이 Panel에 FlowLayout을 적용한 다음
		// 최종적으로 Button 패널에 부착하면된다.
		p.setBackground(Color.YELLOW); //패널에 노란색 적용
		frame.add(p); //윈도우에 판자 붙이기ㅣ
		
		//버튼을 패널에 부착해보자 참고로 개발자가 Panel의 배치관리자를 지정하지 않으면 Default는 바로
		// FlowLayout : 플로우는 컴포넌트 본연의 크기가 유지 된다.
		p.add(bt); //패널에 버튼 부착
		
		frame.setSize(300,250);
		frame.setVisible(true);
		
		

	}

}
