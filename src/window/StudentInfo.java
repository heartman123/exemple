package window;

import javax.swing.JFrame;

import java.awt.*;

import javax.swing.*;
public class StudentInfo extends JFrame {
	 
	
	public StudentInfo(){
		JFrame jf = new JFrame("ѧ����Ϣ����ϵͳ");
//		super("ѧ����Ϣ����ϵͳ");
		jf.setSize(600,500);
		jf.setVisible(true);
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
	
 
	     // ����
	     Dimension windowSize = jf.getSize();
		 int offsetX = (screenSize.width - windowSize.width) / 2;
	     int offsetY = (screenSize.height - windowSize.height) / 2;
		jf.setLocation(offsetX, offsetY);
		
	//	���еڶ��ַ�ʽ
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		�߽粼��
		Container contentPane =  getContentPane();
		contentPane.setLayout(new BorderLayout());
//		contentPane.add(jbutton,BorderLayout.CENTER);
//		contentPane.add(jtext,BorderLayout.NORTH);
//		contentPane.add(jtext);
		
		
	}
	
public static void main(String[] args) {
	StudentInfo stuInfo = new StudentInfo();
	
	
}
}
