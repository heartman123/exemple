package view;

import java.awt.EventQueue;
//private static final long serialVersionUID = 1L;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.adminDao;
import model.UserType;
import model.admin;
import util.Dbutil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField adminName;
	private JPasswordField adminPassword;
	 private JComboBox<UserType> adminTypeComboBox; // �ƶ����༶������
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/\u73ED\u4E3B\u4EFB.png")));
		setTitle("��¼����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("\u73ED\u4E3B\u4EFB\u5DE5\u4F5C\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");
		
		adminName = new JTextField();
		adminName.setColumns(10);
		
		adminPassword = new JPasswordField();
		JButton btnNewButton_2 = new JButton("��¼");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
				
			}
		});
		JButton btnNewButton_3 = new JButton("ȡ��");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B:");
		
		 adminTypeComboBox = new JComboBox<>();
		adminTypeComboBox.setModel(new DefaultComboBoxModel<>(new UserType[] {UserType.ADMIN,UserType.TEACHER}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(138)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(94))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(adminPassword, Alignment.LEADING)
							.addComponent(adminName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addGap(28)))
						.addComponent(adminTypeComboBox, 0, 131, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(79))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(adminPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(adminTypeComboBox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
		btnNewButton.setFocusable(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_3.setFocusable(false);
		setLocationRelativeTo(null);
		
		
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String username = adminName.getText().toString();
		String password = adminPassword.getText().toString();
	UserType selectedItem = (UserType) adminTypeComboBox.getSelectedItem();
if(StringUtil.ifEmpty(username)) {
	JOptionPane.showMessageDialog(this, "�û�������Ϊ��");
	return;
}
if(StringUtil.ifEmpty(password)) {
	JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
	return;
}
admin ad = null;
//�û�����Ա��¼
if(UserType.ADMIN.equals(selectedItem)){
	adminDao admindao = new adminDao();
	admin adminTmp = new admin();
	adminTmp.setName(username);
	adminTmp.setPassword(password);
	 ad = admindao.login(adminTmp);
	if(ad == null) {
		JOptionPane.showMessageDialog(this, "�û��������������");	
		return;
	}
	JOptionPane.showMessageDialog(this, "��ӭ��¼");
	this.dispose();
	new MainFrm(selectedItem, ad).setVisible(true);
//	 EditPasswordFrm editPasswordFrm = new EditPasswordFrm(MainFrm.this, currentUser.getName());
//	"��ʦ".equals(adminTypeComboBox.getName())
}else if(UserType.TEACHER.equals(selectedItem)) {
//	��ʦ��¼
}

	}

	protected void resetButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.adminName.setText("");
		this.adminPassword.setText("");
		
	}
}
