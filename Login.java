
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.xml.crypto.Data;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JPasswordField username, password;
    private JButton loginButton, registerButton;
    static String usernameReceived = "";
    static String passwordReceived = "";

    Login() {

        frame = new JFrame();
        frame.setBounds(100, 100, 318, 252);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 406, 215);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        username = new JPasswordField();
        username.setBounds(100, 37, 115, 19);
        username.setEchoChar((char) 0);
        panel.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(100, 66, 115, 19);
        panel.add(password);
        password.setColumns(10);

        loginButton = new JButton("Zaloguj się");
        loginButton.addActionListener(this);
        loginButton.setBounds(100, 106, 115, 21);
        panel.add(loginButton);

        registerButton = new JButton("Zarejestruj się");
        registerButton.setBounds(100, 137, 115, 21);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        DataBase.connectToDb();

        if (source == loginButton) {

            usernameReceived = String.valueOf(username.getPassword());
            passwordReceived = String.valueOf(password.getPassword());
            try {
                if (DataBase.login("root", "root")) {
                    Client client = new Client();
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Wprowadzono błędne dane");
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (source == registerButton) {
            try {
               AddEmployee.main(null);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}