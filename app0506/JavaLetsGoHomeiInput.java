
import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class JavaLetsGoHomeiInput {

	public static void main(String[] args) {

		// 경고창이 뜨고 Enter a path라는 말과 함께 입력란이 생긴다 prompt와 비슷하게 생각하면 된다.
		String id = JOptionPane.showInputDialog("Enter a path");
		String bright = JOptionPane.showInputDialog("Enter a Bright Level");
		
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		Lighting floorLamp = new Lighting(id+ "/ floor Lamp");
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();

	}

}
