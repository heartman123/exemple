package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.Dbutil;

public class BaseDao {
	protected static Connection conn; // 连接对象

    public BaseDao() {
        try {
            // 获取数据库连接
            conn = Dbutil.getConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database");
            e.printStackTrace();
        }
    }

    // 关闭数据库连接
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
