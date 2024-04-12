package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.Dbutil;

public class BaseDao {
	protected static Connection conn; // ���Ӷ���

    public BaseDao() {
        try {
            // ��ȡ���ݿ�����
            conn = Dbutil.getConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database");
            e.printStackTrace();
        }
    }

    // �ر����ݿ�����
    protected void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the database connection");
            e.printStackTrace();
        }
    }
}
