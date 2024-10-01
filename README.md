# BillEasy

BillEasy is a simple Java-based restaurant management application designed for waiters and administrators to manage orders and payments efficiently. The application features a graphical user interface (GUI) that allows users to easily navigate between the waiter and admin sections.

## Features

### Admin Section
- View and manage orders placed by waiters.
- Calculate total bills based on selected table orders.
- Mark tables as paid or unpaid and select the payment method (UPI or Cash).
- View the payment status of all tables.

### Waiter Section
- Input orders for tables, including item name, price, and quantity.
- Select the table number (1 to 10) for placing orders.
- Orders added by waiters are reflected in the admin section.

## Technologies Used
- Java (JDK 8 or higher)
- Swing (for GUI)
- HashMap (for order and payment management)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SarveshM213/RestoPay.git
2. **Navigate to the project directory**:
   ```bash
   cd BillEasy
   ```
3. **Compile the Java files**:
   ```bash
   javac *.java
   ```
4. **Run the application**:
   ```bash
   java Main
   ```

Replace `MainClass` with the name of your main class that contains the `main` method.

## Usage

1. Start the application.
2. Log in as either an **Admin** or a **Waiter**.
3. As a **Waiter**, select a table number and add orders.
4. As an **Admin**, view orders for each table, calculate totals, and manage payment statuses.

## Future Enhancements
- Add a database for persistent storage of orders and payment status.
- Improve the GUI design with modern UI frameworks.
- Implement user authentication for added security.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to [Java](https://www.java.com) and [Swing](https://docs.oracle.com/javase/tutorial/uiswing/) for providing the tools necessary to build this application.

## Contact

For any questions or feedback, feel free to reach out:

- **Email**: malandkar.sarvesh1@gmail.com
- **GitHub**: [SarveshM213](https://github.com/SarveshM213)
```
