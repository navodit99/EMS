package EMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome {
    private JFrame frame;

    public Welcome() {
        frame = new JFrame("Welcome to Employee Management System");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel("Welcome to Employee Management System");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        JButton button = new JButton("Continue");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the welcome screen
                new Login(); // Open the Login GUI
            }
        });
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Welcome();
    }
}
