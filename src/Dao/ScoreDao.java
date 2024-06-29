package Dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.Score;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ScoreDao extends BaseDao {
	 // ��ѯѧ���ɼ���Ϣ����ͼ����
//    private static final String STUDENT_SCORES_VIEW = "StudentScoresView";

    // ��ѯѧ��ĳ�ſγ̵ĳɼ�
//    public List<StudentScore> getStudentScoresByCourse(int courseId) {
//        List<StudentScore> scores = new ArrayList<>();
//        String sql = "SELECT * FROM " + STUDENT_SCORES_VIEW + " WHERE  ScoreID = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//          ]]  pstmt.setInt(1, courseId);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int studentId = rs.getInt("StudentID");
//                String studentName = rs.getString("StudentName");
//                // ��ȡ�����ɼ���Ϣ...
//                // ������� StudentScore ��һ���Զ�����࣬���ڷ�װѧ���ĳɼ���Ϣ
//                StudentScore score = new StudentScore(studentId, studentName, ...);
//                scores.add(score);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return scores;
//    }
 // ����ɼ���¼�� SQL ���
//    private static final 

    // ����ɼ���¼
    	// ����ɼ���¼
        public boolean addScore(Score score) {
            String INSERT_SCORE_SQL = "INSERT INTO �ɼ��� (ѧ��ѧ��, ����, ��ѧ, Ӣ��, ��ʷ, ����, ����, ��ѧ, ����) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL);
                // ���� SQL ������
                pstmt.setInt(1, score.getStudentId());
                pstmt.setInt(2, score.getChinese());
                pstmt.setInt(3, score.getMath());
                pstmt.setInt(4, score.getEnglish());
                pstmt.setInt(5, score.getHistory());
                pstmt.setInt(6, score.getPhysics());
                pstmt.setInt(7, score.getBiology());
                pstmt.setInt(8, score.getChemistry());
                pstmt.setInt(9, score.getGeography());
                
                // ִ�� SQL �������
                int rowsAffected = pstmt.executeUpdate();
                
                // ���ز�������Ƿ�ɹ�
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                // �������ʧ��
                return false;
            }
        }
    
        // ��ȡ�ɼ��б�
        public List<Score> getScoreList(Score sc) {
            List<Score> scoreList = new ArrayList<>();
            String SELECT_SCORE_SQL = "SELECT * FROM �ɼ���";
            try {
                PreparedStatement pstmt = conn.prepareStatement(SELECT_SCORE_SQL);
                ResultSet rs = pstmt.executeQuery();

                // ��������������ɼ���Ϣ��ӵ��б���
                while (rs.next()) {
                    int studentId = rs.getInt("ѧ��ѧ��");
                    int chinese = rs.getInt("����");
                    int math = rs.getInt("��ѧ");
                    int english = rs.getInt("Ӣ��");
                    int history = rs.getInt("��ʷ");
                    int physics = rs.getInt("����");
                    int biology = rs.getInt("����");
                    int chemistry = rs.getInt("��ѧ");
                    int geography = rs.getInt("����");

                    Score score = new Score(studentId, chinese, math, english, history, physics, biology, chemistry, geography);
                    scoreList.add(score);
                }

                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return scoreList;
        }
        
        public boolean isScoreAdded(Score score) {
            String SELECT_SCORE_SQL = "SELECT * FROM �ɼ��� WHERE ѧ��ѧ�� = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(SELECT_SCORE_SQL);
                pstmt.setInt(1, score.getStudentId());
                ResultSet rs = pstmt.executeQuery();

                // ���������������ݣ����ʾ�ɼ��Ѿ����
                boolean scoreAdded = rs.next();

                rs.close();
                pstmt.close();

                return scoreAdded;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
//         public void getStatsInfo() {
//       	 SELECT ѧ��ѧ��,AVG( ����+ ��ѧ + Ӣ�� + ��ʷ +���� + ����+ ��ѧ+ ����) AS average_score,SUM(����+ ��ѧ + Ӣ�� + ��ʷ +���� + ����+ ��ѧ+ ���� ) AS total_score
//        	FROM 
//        	    �ɼ���
//        	GROUP BY 
//        	    ѧ��ѧ��;
        	 
        	 
//         }
         public Map<String,String> getStatsInfo(int studentID) {
        	 Map<String, String> ret = new HashMap<>();
        	    String sql = "SELECT SUM(���� + ��ѧ + Ӣ�� + ��ʷ + ���� + ���� + ��ѧ + ����)/8.0 AS average_score, "
        	               + "SUM(���� + ��ѧ + Ӣ�� + ��ʷ + ���� + ���� + ��ѧ + ����) AS total_score "
        	               + "FROM �ɼ��� WHERE ѧ��ѧ�� = ?";
        	    try {
        	        PreparedStatement pstmt = conn.prepareStatement(sql);
        	        pstmt.setInt(1, studentID);
        	        ResultSet rs = pstmt.executeQuery();

        	        // �����ѯ���������ƽ���ֺ��ܷ���ӵ����ص� Map ��
        	        if (rs.next()) {
        	            double averageScore = rs.getDouble("average_score");
        	            int totalScore = rs.getInt("total_score");

        	            ret.put("average_score", String.valueOf(averageScore));
        	            ret.put("total_score", String.valueOf(totalScore));
        	        }

        	        rs.close();
        	        pstmt.close();
        	    } catch (SQLException e) {
        	        e.printStackTrace();
        	    }
        	    return ret;
        	 
        	 
         }
      // ��ѯ�γ̵���߷ֺ���ͷ�
         public Map<String, Integer> getCourseStats(String courseName) {
             Map<String, Integer> stats = new HashMap<>();
             String sql = "SELECT MAX(�ܷ�) AS max_score, MIN(�ܷ�) AS min_score FROM �ɼ��� WHERE �γ����� = ?";
             try {
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 pstmt.setString(1, courseName);
                 ResultSet rs = pstmt.executeQuery();

                 if (rs.next()) {
                     // ��ȡ��߷ֺ���ͷֲ���ӵ��������
                     int maxScore = rs.getInt("max_score");
                     int minScore = rs.getInt("min_score");
                     stats.put("max_score", maxScore);
                     stats.put("min_score", minScore);
                 }

                 rs.close();
                 pstmt.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             return stats;
         }
         public boolean deleteScore(Score score) {
        	    String DELETE_SCORE_SQL = "DELETE FROM �ɼ��� WHERE ѧ��ѧ�� = ?";
        	    try {
        	        PreparedStatement pstmt = conn.prepareStatement(DELETE_SCORE_SQL);
        	        // ���� SQL ������
        	        pstmt.setInt(1, score.getStudentId());
        	        
        	        // ִ�� SQL ɾ������
        	        int rowsAffected = pstmt.executeUpdate();
        	        
        	        // ����ɾ�������Ƿ�ɹ�
        	        return rowsAffected > 0;
        	    } catch (SQLException e) {
        	        e.printStackTrace();
        	        // ɾ������ʧ��
        	        return false;
        	    }
        	}
 
        
}
