import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {
    public static void main(String[] args) {
        // MySQL���ݿ����Ӳ���
        String url = "jdbc:mysql://localhost:3306/lab?serversTimezone=GMT";
        String user = "root";
        String password = "123456";

        // SQL���������
        String createTableSQL = "CREATE TABLE IF NOT EXISTS testtable ("
                                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "name VARCHAR(255))";

        try {
            // �������ݿ�����
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("���ӳɹ���");

            // ����Statement����
            Statement statement = connection.createStatement();

            // ������
            statement.executeUpdate(createTableSQL);
            System.out.println("�����ɹ���");

            // �ر�����
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // �����쳣
            System.out.println("����ʧ�ܻ򴴽���ʧ�ܣ�");
            e.printStackTrace();
        }
    }
}

