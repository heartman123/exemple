package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Score;
import model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	public static UserType userType;
	public static Object userObject;
private JDesktopPane desktopPane;
private JMenuItem addTeacherMenuItem;
private JMenuItem addScoreMenuItem;
private JMenuItem ViewScoreMenuItem;
private JMenuItem StudentListMenuItem;
private JMenuItem scoreStatsMenuItem;
private JMenuItem addStudentMenuItem ;
private JMenuItem addCourseMenuItem;

//	 private static String getCurrentUser() {
//	        // 这里可以根据具体情况来实现获取当前用户的逻辑
//	        // 这里只是一个示例，返回一个固定的用户名
//	        return "李四";
//	    }

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm();
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
	public MainFrm(UserType userType,Object userObject) {
		this.userType = userType;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/\u73ED\u4E3B\u4EFB.png")));
		setTitle("\u73ED\u4E3B\u4EFB\u5DE5\u4F5C\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 719);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出系统吗") == JOptionPane.OK_OPTION) {
					System.exit(0);;
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		 addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			addStudent(ae);
			}
		});
		mnNewMenu_1.add(addStudentMenuItem);
		
		 StudentListMenuItem = new JMenuItem("\u5B66\u751F\u5217\u8868");
		StudentListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StudentList(e);
			}
		});
		mnNewMenu_1.add(StudentListMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u73ED\u7EA7\u901A\u77E5");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u73ED\u7EA7\u5217\u8868");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classList(e);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_4 = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);
		
		addScoreMenuItem = new JMenuItem("\u6210\u7EE9\u5F55\u5165");
		addScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScore(e);
			}
		});
		mnNewMenu_4.add(addScoreMenuItem);
		
		 ViewScoreMenuItem = new JMenuItem("\u6210\u7EE9\u67E5\u770B");
		ViewScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreList(e);
				
			}
		});
		mnNewMenu_4.add(ViewScoreMenuItem);
		
		 scoreStatsMenuItem = new JMenuItem("\u6210\u7EE9\u7EDF\u8BA1");
		scoreStatsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsScoreFrm statsScoreFrm  = new StatsScoreFrm();	
				desktopPane.add(statsScoreFrm );
				statsScoreFrm.setVisible(true);
			}
		});
		mnNewMenu_4.add(scoreStatsMenuItem);
		
		JMenuItem ManageScoreMenuItem = new JMenuItem("\u6210\u7EE9\u7BA1\u7406");
		ManageScoreMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			manageScoreFrm(e);
			}
		});
		mnNewMenu_4.add(ManageScoreMenuItem);
		
		JMenu mnNewMenu_5 = new JMenu("\u73ED\u4E3B\u4EFB\u7BA1\u7406");
		menuBar.add(mnNewMenu_5);
		
		 addTeacherMenuItem = new JMenuItem("\u6DFB\u52A0\u73ED\u4E3B\u4EFB");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeacher(e);
			}
		});
		mnNewMenu_5.add(addTeacherMenuItem);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5220\u9664\u73ED\u4E3B\u4EFB");
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_7 = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menuBar.add(mnNewMenu_7);
		
		addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            Addcourse(e);
			}
		});
		mnNewMenu_7.add(addCourseMenuItem);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseList(e);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUs(e);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		contentPane = new JPanel(null);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	    desktopPane = new JDesktopPane();
	    desktopPane.setBackground(new Color(0,128,128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
	
		setLocationRelativeTo(null);		
		setTeacherAuthority();
		
	}

	
	
	protected void manageScoreFrm(ActionEvent e) {
	// TODO Auto-generated method stub
		ManageScoreFrm scoreList  = new ManageScoreFrm ();	
		desktopPane.add(scoreList );
		scoreList.setVisible(true);
	
	
}



	protected void ScoreList(ActionEvent e) {
	// TODO Auto-generated method stub
		ViewScoreFrm scoreList  = new ViewScoreFrm();	
		desktopPane.add(scoreList );
		scoreList.setVisible(true);
	
}



	protected void addScore(ActionEvent e) {
	// TODO Auto-generated method stub
		AddScoreFrm addScore  = new AddScoreFrm();	
		desktopPane.add(addScore );
		addScore.setVisible(true);
	
}



	protected void CourseList(ActionEvent e) {
	// TODO Auto-generated method stub
		ManageCourseFrm courseList  = new ManageCourseFrm();	
		desktopPane.add(courseList );
		courseList .setVisible(true);
}



	protected void Addcourse(ActionEvent e) {
	// TODO Auto-generated method stub
		AddCourseFrm courseAdd  = new AddCourseFrm();	
		desktopPane.add(courseAdd );
		courseAdd .setVisible(true);
	
}



	protected void addTeacher(ActionEvent e) {
	// TODO Auto-generated method stub
		AddTeacherFrm teacherAdd  = new AddTeacherFrm();	
		desktopPane.add(teacherAdd);
		teacherAdd.setVisible(true);
}



	protected void StudentList(ActionEvent e) {
	// TODO Auto-generated method stub
		StudentManagerFrm Studentlist = new StudentManagerFrm();	
		   desktopPane.add(Studentlist);
		   Studentlist.setVisible(true);
}



	protected void classList(ActionEvent e) {
	// TODO Auto-generated method stub
		ClassManageFrm classlist = new ClassManageFrm();	
		   desktopPane.add(classlist);
		   classlist.setVisible(true);
}



	protected void addStudent(ActionEvent ae) {
	// TODO Auto-generated method stub
	StudentAddFrm stuAdd = new StudentAddFrm();	
		   desktopPane.add(stuAdd);
		   stuAdd.setVisible(true);
}


	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
//		String currentUser = getCurrentUser();
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm(MainFrm.this);
		   desktopPane.add(editPasswordFrm);
		   editPasswordFrm.setVisible(true);
	}


	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(this, "关于我们!");
	
	
	}
	private void setTeacherAuthority() {
System.out.println(userType.getName());
		if("班主任".equals(userType.getName())) {
	addTeacherMenuItem.setEnabled(false);
	addStudentMenuItem.setEnabled(false);
	addCourseMenuItem.setEnabled(false);
} 
	}
	}
