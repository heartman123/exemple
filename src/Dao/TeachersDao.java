package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teachers;

public class TeachersDao extends BaseDao{

	public List<Teachers> getTeacherList(Teachers t) {
        List<Teachers> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM ��ʦ��";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // �ӽ�����л�ȡÿ����ʦ����Ϣ
                Teachers teacher = new Teachers();
                teacher.setID(rs.getInt("��ʦ���"));
                teacher.setTeacherName(rs.getString("��ʦ����"));
                teacher.setSex(rs.getString("��ʦ�Ա�"));
                teacher.setAge(rs.getInt("��ʦ����"));

                // ��ÿ����ʦ������ӵ��б���
                teacherList.add(teacher);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherList;
    }
//public int getTeacherIdByName(String teacherName) {
//    int teacherId = -1;
//    try {
//        String sql = "SELECT ��ʦ��� FROM ��ʦ�� WHERE ��ʦ���� = ?";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, teacherName);
//        ResultSet rs = pstmt.executeQuery();
//        if (rs.next()) {
//            teacherId = rs.getInt("��ʦ���");
//        }
//        rs.close();
//        pstmt.close();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return teacherId;
//}
}
