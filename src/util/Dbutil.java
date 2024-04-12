package util;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Dbutil {
	// TODO://把数据库配置信息写到配置文件
    private static final String URL = "jdbc:mysql://localhost:3306/connect";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
 
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Connected to the database!");
                // 连接成功后，可以在这里执行数据库操作
                conn.close(); // 在使用完连接后，务必关闭连接
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database");
            e.printStackTrace();
        }
    }
    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        try {
            // 加载数据库驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
            throw new SQLException("Failed to load JDBC driver");
        }

        // 建立数据库连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
            throw e;
        }

        // 连接成功，返回连接对象
        return connection;
    }


    // 执行查询操作
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            return rs;
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 执行更新操作
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } finally {
            close(conn, pstmt, null);
        }
    }
    // 执行插入操作
    public static int executeInsert(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("Insert failed, no ID obtained.");
            }
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 执行删除操作
    public static int executeDelete(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } finally {
            close(conn, pstmt, null);
        }
    }

    // 关闭数据库连接
//    public static void close(Connection conn)throws Exception {
//     if(conn!=null) {
//    	 conn.close();
//     }
//}
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
