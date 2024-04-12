import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {
    public static void main(String[] args) {
        // MySQL数据库连接参数
        String url = "jdbc:mysql://localhost:3306/lab?serversTimezone=GMT";
        String user = "root";
        String password = "123456";

        // SQL创建表语句
        String createTableSQL = "CREATE TABLE IF NOT EXISTS testtable ("
                                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "name VARCHAR(255))";

        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");

            // 创建Statement对象
            Statement statement = connection.createStatement();

            // 创建表
            statement.executeUpdate(createTableSQL);
            System.out.println("表创建成功！");

            // 关闭连接
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // 处理异常
            System.out.println("连接失败或创建表失败！");
            e.printStackTrace();
        }
    }
}

