import java.util.HashMap;

public class OrderManager {
    private static HashMap<Integer, String> orders = new HashMap<>();

    // Method to add an order for a specific table
    public static void addOrder(int table, String order) {
        if (orders.containsKey(table)) {
            orders.put(table, orders.get(table) + ", " + order);
        } else {
            orders.put(table, order);
        }
    }

    // Method to get all orders
    public static HashMap<Integer, String> getOrders() {
        return orders;
    }

    // Method to get the order for a specific table
    public static String getOrder(int table) {
        return orders.getOrDefault(table, "No Orders for this table");
    }

    // Method to calculate total for a specific table
    public static double calculateTotal(int table) {
        if (!orders.containsKey(table)) return 0;

        double totalAmount = 0;
        String[] items = orders.get(table).split(",");
        for (String item : items) {
            String[] itemDetails = item.split("-");
            double price = Double.parseDouble(itemDetails[1].trim());
            int qty = Integer.parseInt(itemDetails[2].trim());
            totalAmount += price * qty;
        }
        return totalAmount;
    }
}
