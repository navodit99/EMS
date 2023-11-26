package EMS;

import java.sql.*;

public class read {
    public read() {
        try {
            Connection conn = DBhandler.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");

                System.out.println("EmpId: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
            }

            rs.close();
            stmt.close();
            DBhandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new read();
    }
}
