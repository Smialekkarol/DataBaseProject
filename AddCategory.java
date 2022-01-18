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

public class AddCategory extends JDialog {
    private JTextField textField;
    private int keyDepartment;
    private JComboBox categoryBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddCategory dialog = new AddCategory();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setTitle("Kategoria");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddCategory() {
        DataBase.fillBoxDepartment();
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Dział");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setBounds(106, 22, 160, 13);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("Nazwa");
        lblNewLabel.setBounds(106, 74, 160, 13);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(106, 97, 160, 21);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry<Integer, String> entry : DataBase.DepartmentID.entrySet()) {
                    if (Objects.equals(categoryBox.getSelectedItem(), entry.getValue())) {
                        keyDepartment = entry.getKey();
                    }
                }
                DataBase.addCategory(keyDepartment, textField.getText());
            }
        });
        btnNewButton.setBounds(143, 133, 85, 21);
        panel.add(btnNewButton);

        categoryBox = new JComboBox();
        categoryBox.setBounds(106, 43, 160, 21);
        ComboBoxModel categoryModel = new DefaultComboBoxModel(DataBase.department.toArray());
        categoryBox.setModel(categoryModel);
        panel.add(categoryBox);
        setBounds(100, 100, 386, 216);
    }
}
