package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	JDesktopPane desktopPane = new JDesktopPane();
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
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u73ED\u7EA7\u901A\u77E5");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u73ED\u7EA7\u5217\u8868");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
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
		
	
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new BorderLayout(0, 0));
		 
		
	}

	 
	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
//		String currentUser = getCurrentUser();
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm(MainFrm.this);
//		new EditPasswordFrm(this).setVisible(true);
		
		   desktopPane.add(editPasswordFrm);
//		   getContentPane().add(editPasswordFrm, BorderLayout.CENTER);
		   editPasswordFrm.setVisible(true);
	}


	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(this, "关于我们!");
	
	
	}
}
