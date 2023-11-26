// DBhandler.java
package EMS;

import java.sql.*;

public class DBhandler {
    private static final String url = "jdbc:mysql://localhost:3306/Employee";
    private static final String username = "root";
    private static final String password = "N@vod!t98";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
