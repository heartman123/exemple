package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Dbutil;
public class UserDatabase {
	    public static boolean verifyPassword(String username, String password) {
	        // �������д��֤�û�������߼�
	        // �����ѯ���ݿ��е��û����룬Ȼ�����û������������бȽ�
	        // ���������ȷ������true�����򷵻�false
	    	 // ��֤�û������Ƿ���ȷ
	            Connection conn = null;
	            PreparedStatement pstmt = null;
	            ResultSet rs = null;

	            try {
	                // ��ȡ���ݿ�����
	                conn = Dbutil.getConnection();

	                // SQL ��ѯ���
	                String sql = "SELECT password FROM s_admin WHERE name = ?";

	                // ���� PreparedStatement ����
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, username);

	                // ִ�в�ѯ����
	                rs = pstmt.executeQuery();

	                // �����ѯ�������
	                if (rs.next()) {
	                    // ��ȡ���ݿ��д洢������
	                    String storedPassword = rs.getString("password");
	                    
	                    // �Ƚ����ݿ��д洢���������û�����������Ƿ���ͬ
	                    return storedPassword.equals(password);
	                } else {
	                    // û�в�ѯ��ƥ����û��������� false
	                    return false;
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return false;
	            } finally {
	                // �ر����ݿ�����
	                Dbutil.close(conn, pstmt, rs);
	            }
	        
	    	 // �������������֤ͨ����ʵ������Ҫ���ݾ����߼�������Ӧ�Ľ��
	    }
	
}
