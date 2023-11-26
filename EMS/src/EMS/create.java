package EMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class create {
    public create(int id, String name, int age, long salary) {
        try {
            Connection conn = DBhandler.getConnection();

            String query = "INSERT INTO employees (id, name, age, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setLong(4, salary);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record created successfully.");
            }

            preparedStatement.close();
            DBhandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id: ");
        int id = sc.nextInt();
        System.out.println("Enter employee name: ");
        String name = sc.next();
        System.out.println("Enter employee age: ");
        int age = sc.nextInt();
        System.out.println("Enter employee salary: ");
        long salary = sc.nextLong();
        new create(id, name, age, salary);
        sc.close();
    }
}
