package window;

import java.awt.*;

import javax.swing.*;

public class SpringLayoutTest extends JFrame {
JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,12));
	JButton jb1 = new  JButton("按钮1");
	JButton jb2 = new JButton("按钮2");
	JButton jb3 = new JButton("按钮3");
	JButton jb4 = new JButton("按钮4");
	JButton jb5 = new JButton("按钮5");
	JButton jb6 = new JButton("按钮6");
	JButton jb7 = new JButton("按钮7");
	JButton jb8 = new JButton("按钮8");
	JButton jb9 = new JButton("按钮9");
	TextField username = new TextField(12);
	public SpringLayoutTest(){
		super("这是一个流动布局边界");
	Container contentPane = getContentPane();
	setSize(400,500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setVisible(true);
	jPanel.add(jb1);
	jPanel.add(jb2);
	jPanel.add(jb3);
	jPanel.add(jb4);
	jPanel.add(jb5);
	jPanel.add(jb6);
	jPanel.add(jb7);
	jPanel.add(jb8);
	jPanel.add(jb9);
	jPanel.add(username);
	contentPane.add(jPanel);
	}
	public static void main(String[] args) {
		SpringLayoutTest bl = new SpringLayoutTest();
	}
	
}
