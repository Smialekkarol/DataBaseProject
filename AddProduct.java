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

public class AddProduct extends JDialog {

    private JTextField nameField;
    private JTextField descField;
    private JTextField priceField;
    private JComboBox brandBox;
    private JComboBox categoryBox;
    private int keyBrand, keyCategory;

    public static void main(String[] args) {
        try {
            AddProduct dialog = new AddProduct();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Produkt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddProduct() {
        DataBase.fillBoxBrand();
        DataBase.fillBoxCategory();
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Nazwa");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setBounds(138, 67, 96, 13);
        panel.add(lblNewLabel_2);

        nameField = new JTextField();
        nameField.setBounds(138, 90, 96, 13);
        panel.add(nameField);
        nameField.setColumns(10);

        brandBox = new JComboBox();
        brandBox.setBounds(138, 21, 96, 20);
        panel.add(brandBox);
        ComboBoxModel departmentsModel = new DefaultComboBoxModel(DataBase.brand.toArray());
        brandBox.setModel(departmentsModel);

        categoryBox = new JComboBox();
        categoryBox.setBounds(138, 44, 96, 20);
        panel.add(categoryBox);
        ComboBoxModel categoryModel = new DefaultComboBoxModel(DataBase.category.toArray());
        categoryBox.setModel(categoryModel);

        JLabel lblNewLabel = new JLabel("Opis");
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setBounds(138, 119, 96, 13);
        panel.add(lblNewLabel);

        descField = new JTextField();
        descField.setBounds(138, 142, 96, 13);
        panel.add(descField);
        descField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Cena");
        lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_1.setBounds(138, 165, 96, 13);
        panel.add(lblNewLabel_1);

        priceField = new JTextField();
        priceField.setBounds(138, 188, 96, 13);
        panel.add(priceField);
        priceField.setColumns(10);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setBounds(143, 211, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (Map.Entry<Integer, String> entry : DataBase.BrandID.entrySet()) {
                    if (Objects.equals(brandBox.getSelectedItem(), entry.getValue())) {
                        keyBrand = entry.getKey();
                    }
                }

                for (Map.Entry<Integer, String> entry : DataBase.categoryID.entrySet()) {
                    if (Objects.equals(categoryBox.getSelectedItem(), entry.getValue())) {
                        keyCategory = entry.getKey();
                    }
                }
                DataBase.addProduct(keyBrand, keyCategory, nameField.getText(), descField.getText(),
                        Float.parseFloat(priceField.getText()));
            }
        });
        panel.add(btnNewButton);
        setBounds(100, 100, 386, 297);
    }
}
