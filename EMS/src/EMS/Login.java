package EMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    private JFrame frame;
    private JTextField idField, passwordField;

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = passwordField.getText(); // Note: Password handling should be more secure in a real application
                if (id.equals("admin") && password.equals("1234")) {
                    frame.dispose(); // Close the login screen
                    new EmployeeManagementGUI(); // Open the main GUI
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid login credentials");
                }
            }
        });
        panel.add(loginButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
