package window;

import java.awt.*;

import javax.swing.*;

public class SpringLayoutTest extends JFrame {
JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,12));
	JButton jb1 = new  JButton("��ť1");
	JButton jb2 = new JButton("��ť2");
	JButton jb3 = new JButton("��ť3");
	JButton jb4 = new JButton("��ť4");
	JButton jb5 = new JButton("��ť5");
	JButton jb6 = new JButton("��ť6");
	JButton jb7 = new JButton("��ť7");
	JButton jb8 = new JButton("��ť8");
	JButton jb9 = new JButton("��ť9");
	TextField username = new TextField(12);
	public SpringLayoutTest(){
		super("����һ���������ֱ߽�");
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
