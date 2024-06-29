package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.CourseDao;
import Dao.ScoreDao;
import Dao.StudentDao;
import model.ClassCourse;
import model.Score;
import model.StudentBaseInfo;
import model.Teachers;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddScoreFrm extends JInternalFrame {
	private JTextField ScoretextField;
	private JComboBox CoursecomboBox;
    private	JComboBox StudentIDcomboBox;
	private List<ClassCourse> courseList = new ArrayList<>();
	  Score sc = new Score();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddScoreFrm frame = new AddScoreFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddScoreFrm() {
		 setClosable(true);
         setIconifiable(true);
		setTitle("\u6210\u7EE9\u5F55\u5165\u754C\u9762");
		setBounds(100, 100, 544, 427);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u4FE1\u606F:");
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5F97\u6210\u7EE9:");
		
		 CoursecomboBox = new JComboBox();
		
		ScoretextField = new JTextField();
		ScoretextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScore(e);
			}
		});
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u5B66\u53F7");
		
		StudentIDcomboBox = new JComboBox();
		
		JButton continueAddScoreButton = new JButton("\u7EE7\u7EED\u5F55\u5165");
		continueAddScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continueAddScore(e);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addGap(58))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addGap(44)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(submitButton)
									.addGap(31)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(continueAddScoreButton)
									.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
									.addComponent(resetButton)
									.addGap(123))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ScoretextField, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
										.addComponent(StudentIDcomboBox, 0, 93, Short.MAX_VALUE)
										.addComponent(CoursecomboBox, Alignment.TRAILING, 0, 93, Short.MAX_VALUE))
									.addGap(227))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(StudentIDcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CoursecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ScoretextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton)
						.addComponent(continueAddScoreButton))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setCoureseCombox();
//		setStudentNamecomboBox();
		setStudentIDcomboBox() ;
	}
	protected void addScore(ActionEvent e) {
		// TODO Auto-generated method stub
		 // ��ȡ����ĳɼ�
	    String scoreText = ScoretextField.getText();
	    
	    // �������ĳɼ��Ƿ�Ϊ��
	    if(scoreText.isEmpty()) {
	        // ����ɼ�Ϊ�գ���ʾ������Ϣ
	       JOptionPane.showMessageDialog(this, "������ɼ�", "����", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		  ScoreDao scoreDao = new ScoreDao();
		    if(!scoreDao.isScoreAdded(sc)) {
		    	 // ��ʾ��ӳɼ��ɹ�
			    JOptionPane.showMessageDialog(this, "�ɼ���ӳɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
		    }else {
		    	  JOptionPane.showMessageDialog(this, "�ɼ����ʧ��", "ʧ��", JOptionPane.INFORMATION_MESSAGE);
		    }
		    scoreDao.addScore(sc);
	}
	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		ScoretextField.setText("");
	}
	protected void  continueAddScore(ActionEvent e) {
		// TODO Auto-generated method stub
		// ��ȡ��ѡѧ�������Ϳγ���Ϣ
//	    String studentName = (String) StudentNamecomboBox.getSelectedItem();
	    ClassCourse selectedCourse = (ClassCourse) CoursecomboBox.getSelectedItem();

	    // ��ȡ����ĳɼ�
	    String scoreText = ScoretextField.getText();
	    
	    // �������ĳɼ��Ƿ�Ϊ��
	    if(scoreText.isEmpty()) {
	        // ����ɼ�Ϊ�գ���ʾ������Ϣ
	       JOptionPane.showMessageDialog(this, "������ɼ�", "����", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    double score;
	    Score sc = new Score();
	    try {
	        score = Double.parseDouble(scoreText);
	    } catch(NumberFormatException ex) {
	        // ����޷������ɼ�Ϊ���֣���ʾ������Ϣ
	        JOptionPane.showMessageDialog(this, "�ɼ�����������", "����", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    sc.setStudentId(Integer.parseInt(StudentIDcomboBox.getSelectedItem().toString()));
	    if (selectedCourse.getCourseName().equals("����")) {
	        sc.setChinese(Integer.parseInt(scoreText));
	    } 
	    if (selectedCourse.getCourseName().equals("��ѧ")) {
	    	  sc.setMath(Integer.parseInt(scoreText));
	    } 
	    if (selectedCourse.getCourseName().equals("Ӣ��")) {
	    	  sc.setEnglish(Integer.parseInt(scoreText));
	    }
	     if (selectedCourse.getCourseName().equals("��ʷ")) {
	    	  sc.setHistory(Integer.parseInt(scoreText));
	    }
	     if (selectedCourse.getCourseName().equals("����")) {
	    	  sc.setPhysics(Integer.parseInt(scoreText));
	    	  
	    }
        if (selectedCourse.getCourseName().equals("����")) {
	    	  sc.setBiology(Integer.parseInt(scoreText));
	    } if (selectedCourse.getCourseName().equals("��ѧ")) {
	    	  sc.setChemistry(Integer.parseInt(scoreText));
	    }
        if (selectedCourse.getCourseName().equals("����")) {
	    	  sc.setGeography(Integer.parseInt(scoreText));
	    }
	  
	   
	    // ��������
	    ScoretextField.setText("");
		
	}
	private void setCoureseCombox() {
		CourseDao courseDao = new CourseDao();
		courseList = courseDao.getCourseList(new ClassCourse());
		for(ClassCourse course : courseList) {		
			CoursecomboBox.addItem(course);
 
		}
	}
//	private void setStudentNamecomboBox() {
//	    // ��ȡѧ���б�
//	    StudentDao studentDao = new StudentDao();
//	    List<StudentBaseInfo> studentList = studentDao.getStudentList(new StudentBaseInfo());
//	    
//	    // ��ѧ��������ӵ������б����
//	    for(StudentBaseInfo student : studentList) {
//	        StudentNamecomboBox.addItem(student.getName()); // �������ѧ��������һ����Ϊ getName() �ķ�������ȡ����
//	    }
//	}
	private void setStudentIDcomboBox() {
	    // ��ȡѧ���б�
	    StudentDao studentDao = new StudentDao();
	    List<StudentBaseInfo> studentList = studentDao.getStudentList(new StudentBaseInfo());
	    
	    // ��ѧ��������ӵ������б����
	    for(StudentBaseInfo student : studentList) {
	        StudentIDcomboBox.addItem(student.getStudentId()); // �������ѧ��������һ����Ϊ getName() �ķ�������ȡ����
	    }
	}

//	StudentNamecomboBox
//	private void setStudentNamecomboBox() {
//		StudentDao studentDao = new StudentDao();
//		studentList = studentDao.getStudentList(new StudentBaseInfo());
//		ClassCourse course =(ClassCourse) CoursecomboBox.getSelectedItem();
//		for(StudentBaseInfo student : studentList) {		
//			StudentNamecomboBox.addItem(student);
////			StudentNamecomboBox.addItem(course);
// 
//		}
	

}
