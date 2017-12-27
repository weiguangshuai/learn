package jdbc;

import java.sql.*;

/**
 * @author weigs
 * @date 2017/12/26 0026
 */
public class PrepareStatementDemo {

    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPreSta("weigs", "weigs");
            preparedStatement.setInt(1, 1);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getRow());
                System.out.println(result.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement getPreSta(String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop", user, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id=?");
        return preparedStatement;
    }
}
