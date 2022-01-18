import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.KeyStroke;

public class Client implements ActionListener {

    private JFrame frame;
    private JTable table;
    private JComboBox<String> comboBox;
    public static DefaultTableModel tableModel;
    static int rowSelected;
    static String solve;

    Client() {
        tableModel = new DefaultTableModel();
        frame = new JFrame();
        frame.setBounds(200, 200, 652, 426);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(30, 10, 571, 31);
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 5, 0, 0));

        DataBase.getProducts();
        comboBox = new JComboBox<String>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().toString().equals("Produkty")) {
                    DataBase.getProducts();

                }
                if (comboBox.getSelectedItem().toString().equals("Marki")) {
                    DataBase.getBrands();

                }
                if (comboBox.getSelectedItem().toString().equals("Kategorie")) {
                    DataBase.getCategories();

                }
                if (comboBox.getSelectedItem().toString().equals("Dzialy")) {
                    DataBase.getDepartments();

                }
                if (comboBox.getSelectedItem().toString().equals("Dostawcy")) {
                    DataBase.getSuppliers();
                }
                if (comboBox.getSelectedItem().toString().equals("Pracownicy")) {
                    DataBase.getEmployyes();

                }
                if (comboBox.getSelectedItem().toString().equals("Klienci")) {
                    DataBase.getClients();
                }
                if (comboBox.getSelectedItem().toString().equals("Sklepy")) {
                    DataBase.getMagazines();
                }
            }

        });
        comboBox.setModel(
                new DefaultComboBoxModel<String>(
                        new String[] { "Produkty", "Marki", "Kategorie", "Dzialy", "Dostawcy", "Pracownicy", "Klienci",
                                "Sklepy" }));
        panel_1.add(comboBox);

        JButton btnNewButton_3 = new JButton("Raporty");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_1.add(btnNewButton_3);

        JButton btnNewButton_2 = new JButton("Zamówienia");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_1.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Profil");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel_1.add(btnNewButton_1);

        JButton btnNewButton = new JButton("Wyloguj");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                Login client = new Login();
            }

        });
        panel_1.add(btnNewButton);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(30, 51, 571, 287);
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 0));

        String[] columnNames = {};

        Object[][] data = {

        };

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    rowSelected = target.getSelectedRow();
                    System.out.println(rowSelected);
                }

            }
        });

        panel_2.add(scrollPane, "name_1663643406686000");

        JButton btnNewButton_6 = new JButton("Nowy");
        btnNewButton_6.setBounds(387, 358, 101, 21);
        panel.add(btnNewButton_6);
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (comboBox.getSelectedItem().toString()) {
                    case "Produkty":
                        AddProduct.main(null);
                        System.out.println("Produkty");
                        break;

                    case "Marki":
                        AddBrand.main(null);
                        break;

                    case "Kategorie":
                        AddCategory.main(null);
                        break;

                    case "Dzialy":
                        AddDepartment.main(null);
                        break;

                    case "Dostawcy":
                        AddSupplier.main(null);
                        break;
                    case "Klienci":
                        RegisterForm.main(null);
                        break;
                    case "Pracownicy":
                        AddEmployee.main(null);
                        break;
                }

            }
        });

        JButton btnNewButton_4 = new JButton("Usuń");
        btnNewButton_4.setBounds(498, 358, 103, 21);
        panel.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }

    public void deleteRow() {

        tableModel.removeRow(rowSelected);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}