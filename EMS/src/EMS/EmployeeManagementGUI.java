// EmployeeManagementGUI.java
package EMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagementGUI {
    private JFrame frame;
    private JTextField idField, nameField, ageField, salaryField;

    public EmployeeManagementGUI() {
        frame = new JFrame("Employee Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        panel.add(salaryField);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    long salary = Long.parseLong(salaryField.getText());
                    new create(id, name, age, salary);
                    JOptionPane.showMessageDialog(frame, "Record created successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
                }
            }
        });
        panel.add(createButton);

        JButton readButton = new JButton("Read");
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new read();
            }
        });
        panel.add(readButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idtofind = Integer.parseInt(idField.getText());
                    String newname = nameField.getText();
                    int newage = Integer.parseInt(ageField.getText());
                    long newsalary = Long.parseLong(salaryField.getText());
                    new update(idtofind, newname, newage, newsalary);
                    JOptionPane.showMessageDialog(frame, "Record updated successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
                }
            }
        });
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idtodelete = Integer.parseInt(idField.getText());
                    new delete(idtodelete);
                    JOptionPane.showMessageDialog(frame, "Record deleted successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.");
                }
            }
        });
        panel.add(deleteButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeManagementGUI();
    }
}
