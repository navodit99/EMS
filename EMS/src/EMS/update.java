package EMS;

import java.sql.*;
import java.util.Scanner;

public class update {
    public update(int idtofind, String newname, int newage, long newsalary) {
        try {
            Connection conn = DBhandler.getConnection();

            String query = "UPDATE employees SET name = ?, age = ?, salary = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, newname);
            preparedStatement.setInt(2, newage);
            preparedStatement.setLong(3, newsalary);
            preparedStatement.setInt(4, idtofind);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found for update: " + idtofind);
            }

            preparedStatement.close();
            DBhandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee ID you want to update:");
        int idtofind = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the new name:");
        String newname = sc.nextLine();

        System.out.println("Enter the new age:");
        int newage = sc.nextInt();

        System.out.println("Enter the new salary:");
        long newsalary = sc.nextLong();

        new update(idtofind, newname, newage, newsalary);

        sc.close();
    }
}
