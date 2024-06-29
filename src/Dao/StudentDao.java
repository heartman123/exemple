package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.StudentBaseInfo;
import util.StringUtil;

public class StudentDao extends BaseDao {
public boolean addStudent(StudentBaseInfo sbf) {
	 String sql = "INSERT INTO ѧ������������ (ѧ��ѧ��, ѧ������, ����, �Ա�, ����, ������ò, ְ��, ��ʦ���) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	 try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, sbf.getStudentId());
	        pstmt.setString(2, sbf.getName());
	        pstmt.setInt(3, sbf.getAge());
	        pstmt.setString(4, sbf.getGender());
	        pstmt.setString(5, sbf.getNationality());
	        pstmt.setString(6, sbf.getPoliticalStatus());
	        pstmt.setString(7, sbf.getPosition());
	        pstmt.setInt(8, sbf.getTeacherId());

	        int rowsAffected = pstmt.executeUpdate();
	        pstmt.close();
	        
	        // ���Ӱ�����������0�����ʾ����ɹ�
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // ����ʧ��
	        return false;
	    }
	
}
public  List<StudentBaseInfo> getStudentList(StudentBaseInfo student) {
  
    List<StudentBaseInfo> studentList = new ArrayList<>();
    String sql = "SELECT * FROM ѧ������������";
    StringBuffer sqlString = new StringBuffer(sql);
    
    if(!StringUtil.ifEmpty(student.getName())) {
    	sqlString.append(" AND ѧ������ LIKE '%" + student.getName() + "%'");   	
    }
    if(student.getStudentId() != 0) {
    	sqlString.append(" AND ѧ��ѧ�� LIKE '%" + student.getStudentId() + "%'");
    }   
    // ��ձ���е�����
    try {    
        PreparedStatement pstmt = conn.prepareStatement(sqlString.toString() .replaceFirst("AND", "WHERE"));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // �ӽ�����л�ȡÿ��ѧ������Ϣ
            int studentId = rs.getInt("ѧ��ѧ��");
            String name = rs.getString("ѧ������");
            int age = rs.getInt("����");
            String gender = rs.getString("�Ա�");
            String nationality = rs.getString("����");
            String politicalStatus = rs.getString("������ò");
            String position = rs.getString("ְ��");
            int teacherId = rs.getInt("��ʦ���");

            // ����һ�� StudentBaseInfo ���󣬲���ѧ����Ϣ��ӵ��б���
            StudentBaseInfo Student = new StudentBaseInfo(studentId, name, age, gender, nationality, politicalStatus, position, teacherId);
            studentList.add(Student);
        }
   
    rs.close();
    pstmt.close();
} catch (SQLException e) {
    e.printStackTrace();
}
    return studentList;
}
public boolean deleteStudent(int studentId) {
	
	 String sql = "DELETE FROM ѧ������������ WHERE ѧ��ѧ�� = ?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, studentId);

	        int rowsAffected = pstmt.executeUpdate();
	        pstmt.close();

	        // ���Ӱ�����������0�����ʾɾ���ɹ�
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // ɾ��ʧ��
	        return false;
	    }
	
}
public boolean updateStudent(StudentBaseInfo student) {
    String sql = "UPDATE ѧ������������ SET ѧ������=?, �Ա�=?, ����=?, ������ò=?, ְ��=? WHERE ѧ��ѧ��=?";
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getGender());
        pstmt.setString(3, student.getNationality());
        pstmt.setString(4, student.getPoliticalStatus());
        pstmt.setString(5, student.getPosition());
        pstmt.setInt(6, student.getStudentId());
       
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();

        // ���Ӱ�����������0�����ʾ���³ɹ�
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        // ����ʧ��
        return false;
    }
}
public String getStudentNameById(int studentId) {
    String studentName = null;
    String sql = "SELECT ѧ������ FROM ѧ������������ WHERE ѧ��ѧ�� = ?";
    
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            studentName = rs.getString("ѧ������");
        }
        
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return studentName;
}

}
