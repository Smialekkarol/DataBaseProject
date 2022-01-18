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
import java.util.*;
import java.util.Map;

public class AddBrand extends JDialog {
    private JTextField textField_2;
    private JTextField textField;
    private int keySupplier;
    private JComboBox comboBox_1;

    public static void main(String[] args) {
        try {
            AddBrand dialog = new AddBrand();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Marka");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AddBrand() {
        DataBase.fillBoxSupplier();
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Nazwa");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setBounds(106, 67, 160, 13);
        panel.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(106, 90, 160, 13);
        panel.add(textField_2);
        textField_2.setColumns(10);

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(106, 44, 160, 20);
        ComboBoxModel supplierModel = new DefaultComboBoxModel(DataBase.supplier.toArray());
        comboBox_1.setModel(supplierModel);
        panel.add(comboBox_1);

        JLabel lblNewLabel = new JLabel("Kraj produkcji");
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setBounds(106, 119, 160, 13);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(106, 142, 160, 13);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Dostawca");
        lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_1.setBounds(106, 21, 160, 13);
        panel.add(lblNewLabel_1);
        setBounds(100, 100, 386, 266);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry<Integer, String> entry : DataBase.SupplierID.entrySet()) {
                    if (Objects.equals(comboBox_1.getSelectedItem(), entry.getValue())) {
                        keySupplier = entry.getKey();
                    }
                }
                DataBase.addBrand(keySupplier, textField_2.getText(), textField.getText());
            }
        });
        btnNewButton.setBounds(138, 178, 85, 21);
        panel.add(btnNewButton);
        setBounds(100, 100, 386, 266);
    }
}
