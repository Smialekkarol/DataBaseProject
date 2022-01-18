
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDepartment extends JDialog {
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddDepartment dialog = new AddDepartment();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Dział");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddDepartment() {
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Nazwa");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setBounds(106, 22, 160, 13);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("Opis");
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setBounds(106, 74, 160, 13);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(106, 97, 160, 21);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataBase.addDepartment(textField.getText(), textField_1.getText());
            }
        });
        btnNewButton.setBounds(143, 133, 85, 21);
        panel.add(btnNewButton);

        textField_1 = new JTextField();
        textField_1.setBounds(106, 45, 160, 19);
        panel.add(textField_1);
        textField_1.setColumns(10);
        setBounds(100, 100, 386, 216);
    }
}
