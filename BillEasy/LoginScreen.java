import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private JFrame frame;
    
    public void showLoginScreen() {
        frame = new JFrame("RestoPay Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("Select Role:");
        panel.add(label);

        JButton adminButton = new JButton("Admin");
        JButton waiterButton = new JButton("Waiter");
        
        // Admin login button functionality
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the login screen
                new AdminDashboard().showAdminDashboard(); // Open Admin Dashboard
            }
        });

        // Waiter login button functionality
        waiterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the login screen
                new WaiterDashboard().showWaiterDashboard(); // Open Waiter Dashboard
            }
        });

        panel.add(adminButton);
        panel.add(waiterButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
