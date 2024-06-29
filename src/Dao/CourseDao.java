package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassCourse;
import model.StudentBaseInfo;
import util.StringUtil;

public class CourseDao extends BaseDao{
	public boolean addCourse(ClassCourse course) {
		 String sql = "INSERT INTO �༶�γ̱� VALUES (?, ?, ?, ?, ?)";
	        try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, course.getCourseId());
	            pstmt.setString(2, course.getCourseName());
	            pstmt.setString(3, course.getClassTime());
	            pstmt.setString(4, course.getTeacherName());
	            pstmt.setInt(5, course.getTeacherId());

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
	public  List<ClassCourse> getCourseList(ClassCourse course) {
		  
	    List<ClassCourse> courseList = new ArrayList<>();
	    String sql = "SELECT * FROM �༶�γ̱�";
	    StringBuffer sqlString = new StringBuffer(sql);
	    
	    if(!StringUtil.ifEmpty(course.getCourseName())) {
	    	sqlString.append(" AND �γ����� LIKE '%" + course.getCourseName() + "%'");   	
	    }
	    if(course.getCourseId() != 0) {
	    	sqlString.append(" AND �γ̱�� LIKE '%" + course.getCourseId() + "%'");
	    }   
	    if (!StringUtil.ifEmpty(course.getTeacherName())) {
	        sqlString.append(" AND ��ʦ���� LIKE '%" + course.getTeacherName() + "%'");
	    }
	    // ��ձ���е�����
	    try {    
	        PreparedStatement pstmt = conn.prepareStatement(sqlString.toString() .replaceFirst("AND", "WHERE"));
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            
	        	   int courseId = rs.getInt("�γ̱��");
	                String courseName = rs.getString("�γ�����");
	                String classTime = rs.getString("�Ͽ�ʱ��");
	                String teacherName = rs.getString("��ʦ����");
	                int teacherId = rs.getInt("��ʦ���");
	                
	                ClassCourse courseInfo = new ClassCourse(courseId, courseName, classTime, teacherName, teacherId);
	                courseList.add(courseInfo);
	        }
	   
	    rs.close();
	    pstmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	    return courseList;
	}
	public boolean deleteCourse(int studentId) {
		
		 String sql = "DELETE FROM �༶�γ̱� WHERE �γ̱�� = ?";
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
	public boolean updateCourse(ClassCourse course) {
	    String sql = "UPDATE �༶�γ̱� SET �γ̱��=?, �γ�����=?, �Ͽ�ʱ��=?, ��ʦ����=? WHERE �γ̱��=?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getClassTime());
            pstmt.setString(4, course.getTeacherName());
            pstmt.setInt(5, course.getCourseId());
	      
	       
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
}
