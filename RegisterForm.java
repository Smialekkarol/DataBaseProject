import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegisterForm extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField NIPField;
    private JTextField companyField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField countryField;
    private JTextField postcodeField;
    private JTextField cityField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField vipField;
    
    static RegisterForm dialog;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            dialog = new RegisterForm();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Nowy Klient");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegisterForm() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            NIPField = new JTextField("NIP");
            NIPField.setBounds(95, 66, 96, 19);
            contentPanel.add(NIPField);
            NIPField.setColumns(10);
        }
        {
            companyField = new JTextField("Firma");
            companyField.setBounds(95, 25, 96, 19);
            contentPanel.add(companyField);
            companyField.setColumns(10);
        }
        {
            nameField = new JTextField("Imię");
            nameField.setBounds(95, 189, 96, 19);
            contentPanel.add(nameField);
            nameField.setColumns(10);
        }
        {
            surnameField = new JTextField("Nazwisko");
            surnameField.setBounds(95, 107, 96, 19);
            contentPanel.add(surnameField);
            surnameField.setColumns(10);
        }
        {
            countryField = new JTextField("Kraj");
            countryField.setBounds(95, 148, 96, 19);
            contentPanel.add(countryField);
            countryField.setColumns(10);
        }
        {
            postcodeField = new JTextField("Kod pocztowy");
            postcodeField.setColumns(10);
            postcodeField.setBounds(241, 25, 96, 19);
            contentPanel.add(postcodeField);
        }
        {
            cityField = new JTextField("Miasto");
            cityField.setColumns(10);
            cityField.setBounds(241, 66, 96, 19);
            contentPanel.add(cityField);
        }
        {
            addressField = new JTextField("Adres");
            addressField.setColumns(10);
            addressField.setBounds(241, 107, 96, 19);
            contentPanel.add(addressField);
        }
        {
            phoneField = new JTextField("Numer telefonu");
            phoneField.setColumns(10);
            phoneField.setBounds(241, 148, 96, 19);
            contentPanel.add(phoneField);
        }
        {
            vipField = new JTextField("poziom VIP");
            vipField.setColumns(10);
            vipField.setBounds(241, 189, 96, 19);
            contentPanel.add(vipField);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Utwórz konto");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DataBase.createClient(Integer.parseInt(NIPField.getText()), companyField.getText(), nameField.getText(), surnameField.getText(), countryField.getText(), postcodeField.getText(), cityField.getText(), addressField.getText(), phoneField.getText(), Integer.parseInt(vipField.getText()) );
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }
}
