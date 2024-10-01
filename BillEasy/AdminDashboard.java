import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AdminDashboard {
    private JFrame frame;

    // To store the payment status of tables
    private HashMap<Integer, String> tablePaymentStatus = new HashMap<>();

    public void showAdminDashboard() {
        frame = new JFrame("Admin Dashboard - RestoPay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Increased size to accommodate the new section

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Dropdown to select table
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel selectTableLabel = new JLabel("Select Table No.:");
        JComboBox<Integer> tableNoDropdown = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        topPanel.add(selectTableLabel);
        topPanel.add(tableNoDropdown);

        // Text area to display order details
        JTextArea orderDetailsArea = new JTextArea(10, 30);
        orderDetailsArea.setEditable(false);
        JScrollPane orderScrollPane = new JScrollPane(orderDetailsArea);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton viewOrderButton = new JButton("View Orders");
        JButton calculateTotalButton = new JButton("Calculate Total");
        JButton switchUserButton = new JButton("Switch to Waiter");

        buttonPanel.add(viewOrderButton);
        buttonPanel.add(calculateTotalButton);
        buttonPanel.add(switchUserButton);

        // Payment options checkboxes
        JPanel paymentPanel = new JPanel(new GridLayout(1, 2));
        JCheckBox upiCheckbox = new JCheckBox("UPI");
        JCheckBox cashCheckbox = new JCheckBox("Cash");
        paymentPanel.add(upiCheckbox);
        paymentPanel.add(cashCheckbox);

        // Paid/Unpaid Section
        JPanel rightPanel = new JPanel(new BorderLayout());
        JLabel paidStatusLabel = new JLabel("Paid/Unpaid Status");
        DefaultListModel<String> paidStatusModel = new DefaultListModel<>();
        JList<String> paidStatusList = new JList<>(paidStatusModel);
        JScrollPane paidStatusScrollPane = new JScrollPane(paidStatusList);

        JButton markAsPaidButton = new JButton("Mark as Paid");
        JButton markAsUnpaidButton = new JButton("Mark as Unpaid");

        // Add paid/unpaid buttons to a panel
        JPanel paidButtonPanel = new JPanel(new GridLayout(2, 1));
        paidButtonPanel.add(markAsPaidButton);
        paidButtonPanel.add(markAsUnpaidButton);

        // Right panel for payment status and buttons
        rightPanel.add(paidStatusLabel, BorderLayout.NORTH);
        rightPanel.add(paidStatusScrollPane, BorderLayout.CENTER);
        rightPanel.add(paidButtonPanel, BorderLayout.SOUTH);

        // View orders for a selected table
        viewOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tableNo = (int) tableNoDropdown.getSelectedItem();
                String orders = OrderManager.getOrder(tableNo);
                orderDetailsArea.setText("Orders for Table " + tableNo + ":\n" + orders);
            }
        });

        // Calculate total for a selected table
        calculateTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tableNo = (int) tableNoDropdown.getSelectedItem();
                double total = OrderManager.calculateTotal(tableNo);
                orderDetailsArea.append("\nTotal Bill: " + total);
            }
        });

        // Mark table as Paid
        markAsPaidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tableNo = (int) tableNoDropdown.getSelectedItem();
                String paymentMethod = upiCheckbox.isSelected() ? "UPI" : (cashCheckbox.isSelected() ? "Cash" : "No Payment Selected");
                if (!paymentMethod.equals("No Payment Selected")) {
                    tablePaymentStatus.put(tableNo, "Paid via " + paymentMethod);
                    updatePaidStatusList(paidStatusModel);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a payment method (UPI or Cash)");
                }
            }
        });

        // Mark table as Unpaid
        markAsUnpaidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tableNo = (int) tableNoDropdown.getSelectedItem();
                tablePaymentStatus.put(tableNo, "Unpaid");
                updatePaidStatusList(paidStatusModel);
            }
        });

        // Switch user to Waiter role
        switchUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginScreen().showLoginScreen();
            }
        });

        // Add components to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH); // Table selection
        mainPanel.add(orderScrollPane, BorderLayout.CENTER); // Order details display
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Buttons
        mainPanel.add(paymentPanel, BorderLayout.WEST); // Payment checkboxes
        mainPanel.add(rightPanel, BorderLayout.EAST); // Paid/Unpaid section

        // Final setup
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Method to update the Paid/Unpaid status list
    private void updatePaidStatusList(DefaultListModel<String> paidStatusModel) {
        paidStatusModel.clear();
        for (int tableNo : tablePaymentStatus.keySet()) {
            String status = "Table " + tableNo + ": " + tablePaymentStatus.get(tableNo);
            paidStatusModel.addElement(status);
        }
    }
}
