import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the Login Screen
        SwingUtilities.invokeLater(() -> {
            LoginScreen login = new LoginScreen();
            login.showLoginScreen();
        });
    }
}
