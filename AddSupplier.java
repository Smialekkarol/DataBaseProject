import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddSupplier extends JDialog {
    private JTextField nameField;
    private JTextField nipField;
    private JTextField countryField;
    private JTextField postcodeField;
    private JTextField cityField;
    private JTextField addressField;
    private JTextField numberField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddSupplier dialog = new AddSupplier();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Dostawca");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddSupplier() {
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Nazwa");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setBounds(106, 10, 160, 13);
        panel.add(lblNewLabel_2);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(143, 374, 85, 21);
        panel.add(btnNewButton);

        nameField = new JTextField();
        nameField.setBounds(106, 33, 160, 19);
        panel.add(nameField);
        nameField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("NIP");
        lblNewLabel_1.setBounds(106, 62, 160, 13);
        lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblNewLabel_1);

        nipField = new JTextField();
        nipField.setBounds(106, 85, 160, 19);
        panel.add(nipField);
        nipField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Kraj");
        lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_3.setBounds(106, 114, 160, 13);
        panel.add(lblNewLabel_3);

        countryField = new JTextField();
        countryField.setBounds(106, 137, 160, 19);
        panel.add(countryField);
        countryField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Kod pocztowy");
        lblNewLabel_4.setBounds(106, 166, 160, 13);
        lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblNewLabel_4);

        postcodeField = new JTextField();
        postcodeField.setBounds(106, 189, 160, 19);
        panel.add(postcodeField);
        postcodeField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Miasto");
        lblNewLabel_5.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_5.setBounds(106, 218, 160, 13);
        panel.add(lblNewLabel_5);

        cityField = new JTextField();
        cityField.setBounds(106, 241, 160, 19);
        panel.add(cityField);
        cityField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Adres");
        lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_6.setBounds(106, 270, 160, 13);
        panel.add(lblNewLabel_6);

        addressField = new JTextField();
        addressField.setBounds(106, 293, 160, 19);
        panel.add(addressField);
        addressField.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Numer telefonu");
        lblNewLabel_7.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_7.setBounds(106, 322, 160, 13);
        panel.add(lblNewLabel_7);

        numberField = new JTextField();
        numberField.setBounds(106, 345, 160, 19);
        panel.add(numberField);
        numberField.setColumns(10);
        setBounds(100, 100, 386, 456);

        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                DataBase.addSupplier(nameField.getText(), nipField.getText(), countryField.getText(),
                        postcodeField.getText(),
                        cityField.getText(), addressField.getText(), numberField.getText());
            }
        });

    }
}
