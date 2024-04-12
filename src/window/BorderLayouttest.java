package window;

import java.awt.*;

import javax.swing.*;

public class BorderLayouttest extends JFrame {

	JButton jb = new  JButton("按钮");
	JRadioButton jradiob  = new JRadioButton("按钮2");
	JCheckBox jcheckbox = new JCheckBox();
	JTextArea jtext = new JTextArea("这是一个文本框" ,10,20);;
	public BorderLayouttest(){
		super("这是一个测试边界");
	Container contentPane = getContentPane();
	setSize(400,500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setVisible(true);
	contentPane.setLayout(new BorderLayout());
	contentPane.add(jb);
	contentPane.add(jtext,BorderLayout.NORTH);
	contentPane.add(jradiob,BorderLayout.WEST);
	contentPane.add(jcheckbox,BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		BorderLayouttest bl = new BorderLayouttest();
	}
	
}
