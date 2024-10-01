import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaiterDashboard {
    private JFrame frame;

    public void showWaiterDashboard() {
        frame = new JFrame("Waiter Dashboard - RestoPay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel tableLabel = new JLabel("Table No (1-10):");
        JComboBox<Integer> tableNo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        JLabel itemNameLabel = new JLabel("Item Name:");
        JTextField itemNameField = new JTextField();
        JLabel itemPriceLabel = new JLabel("Item Price:");
        JTextField itemPriceField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();
        JButton addButton = new JButton("Add Order");
        JButton switchUserButton = new JButton("Switch to Admin");

        panel.add(tableLabel);
        panel.add(tableNo);
        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(itemPriceLabel);
        panel.add(itemPriceField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(addButton);
        panel.add(switchUserButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int table = (int) tableNo.getSelectedItem();
                String itemName = itemNameField.getText();
                double itemPrice = Double.parseDouble(itemPriceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                String order = itemName + " - " + itemPrice + " - " + quantity;
                OrderManager.addOrder(table, order);

                JOptionPane.showMessageDialog(frame, "Order added successfully!");
            }
        });

        switchUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginScreen().showLoginScreen();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
