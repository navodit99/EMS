package EMS;

import java.sql.*;
import java.util.Scanner;

public class delete {
    public delete(int idtodelete) {
        try {
            Connection conn = DBhandler.getConnection();

            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idtodelete);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found for deletion: " + idtodelete);
            }

            preparedStatement.close();
            DBhandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id to delete details: ");
        int idtodelete = sc.nextInt();
        new delete(idtodelete);
        sc.close();
    }
}
