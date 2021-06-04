package app0604.tree.xml;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

//XML을 파싱하여 그 결과를 JTree에 출력하기
public class TreeXMLApp extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	public TreeXMLApp() {
		tree = new JTree();
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TreeXMLApp();
	}

}
