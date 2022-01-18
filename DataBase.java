import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Map;

public class DataBase {

    private static Connection con;
    static int data;
    static List<String> brand = new ArrayList<>();
    static List<String> category = new ArrayList<>();
    static List<String> supplier = new ArrayList<>();
    static List<String> department = new ArrayList<>();

    static Map<Integer, String> categoryID = new HashMap<>();
    static Map<Integer, String> BrandID = new HashMap<>();
    static Map<Integer, String> DepartmentID = new HashMap<>();
    static Map<Integer, String> SupplierID = new HashMap<>();

    public static boolean connectToDb() {

        try {
            String dbUrl = "jdbc:postgresql://pascal.fis.agh.edu.pl:5432/u9smialek";
            String dbUser = "u9smialek";
            String dbPass = "9smialek";
            con = DriverManager.getConnection(dbUrl,
                    dbUser, dbPass);
        } catch (SQLException se) {
            System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
            se.printStackTrace();
            System.exit(1);
        }
        if (con != null) {
            System.out.println("Polaczenie z baza danych OK ! ");

            return true;
        }

        else
            System.out.println("Brak polaczenia z baza, dalsza czesc aplikacji nie jest wykonywana.");
        return false;
    }

    public static void fillBoxCategory() {
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.CATEGORY;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                category.add(rs.getString("Name"));
                categoryID.put(rs.getInt("Category_ID"), rs.getString("Name"));
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillBoxDepartment() {
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.department;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                department.add(rs.getString("Name"));
                DepartmentID.put(rs.getInt("Department_ID"), rs.getString("Name"));
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillBoxBrand() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.BRAND;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BrandID.put(rs.getInt("Brand_ID"), rs.getString("Name"));
                brand.add(rs.getString("Name"));
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillBoxSupplier() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.supplier;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                supplier.add(rs.getString("Name"));
                SupplierID.put(rs.getInt("Supplier_ID"), rs.getString("Name"));
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getProducts() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.PRODUCT;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String product_ID = Integer.toString((rs.getInt("Product_ID")));
                String name = rs.getString("Name");
                String price = Float.toString((rs.getFloat("Price")));

                // add header of the table
                String header[] = new String[] { "ID PRODUKTU", "Nazwa", "Cena" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { product_ID, name, price });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getBrands() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.BRAND;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Brand_ID = Integer.toString((rs.getInt("Brand_ID")));
                String Name = rs.getString("Name");
                String manufacture_country = rs.getString("manufacture_country");
                // add header of the table
                String header[] = new String[] { "ID Marki", "Nazwa", "Kraj produkcji" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Brand_ID, Name, manufacture_country });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getCategories() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.CATEGORY;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Category_ID = Integer.toString((rs.getInt("Category_ID")));
                String Name = rs.getString("Name");
                // add header of the table
                String header[] = new String[] { "ID Kategorii", "Nazwa" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Category_ID, Name });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDepartments() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.DEPARTMENT;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Department_ID = Integer.toString((rs.getInt("Department_ID")));
                String Name = rs.getString("Name");
                String Description = rs.getString("Description");

                // add header of the table
                String header[] = new String[] { "ID Działu", "Nazwa", "Opis" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Department_ID, Name, Description });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSuppliers() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.supplier;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Supplier_ID = Integer.toString((rs.getInt("Supplier_ID")));
                String Name = rs.getString("Name");
                String NIP = rs.getString("NIP");

                // add header of the table
                String header[] = new String[] { "ID Dostawcy", "Nazwa", "NIP" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Supplier_ID, Name, NIP });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getEmployyes() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.employee;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Employee_ID = Integer.toString((rs.getInt("Employee_ID")));
                String Fname = rs.getString("Fname");
                String Lname = rs.getString("Lname");
                String phone = rs.getString("Phone");

                // add header of the table
                String header[] = new String[] { "ID pracownika", "Imie", "Nazwisko", "telefon" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Employee_ID, Fname, Lname, phone });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getClients() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.customer;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Customer_ID = Integer.toString((rs.getInt("Customer_ID")));
                String Organization_name = rs.getString("Organization_name");
                String NIP = rs.getString("NIP");

                // add header of the table
                String header[] = new String[] { "ID klienta", "Nazwa", "NIP" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Customer_ID, Organization_name, NIP });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getMagazines() {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM Project.store;",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            Client.tableModel.setRowCount(0);
            while (rs.next()) {

                String Store_ID = Integer.toString((rs.getInt("Store_ID")));
                String Name = rs.getString("Name");
                String Postcode = rs.getString("Postcode");
                String Address = rs.getString("Address");

                // add header of the table
                String header[] = new String[] { "ID Sklepu", "Nazwa", "kod pocztowy", "Adres" };

                // add header to the table model
                Client.tableModel.setColumnIdentifiers(header);

                Client.tableModel.addRow(new Object[] { Store_ID, Name, Postcode, Address });
                Client.tableModel.fireTableDataChanged();

            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean login(String username, String password) {
        try {

            PreparedStatement pst = con.prepareStatement(
                    "SELECT Employee_ID from Project.employee_data e WHERE e.username = ? AND e.password = ?;");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data = rs.getRow();
            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (data != 0) {
            System.out.println(data);
            return true;
        }
        return false;

    }

    public static void createClient(int nip, String company, String name, String surname, String country,
            String postcode, String city, String address, String phone, int vip) {
        try {

            PreparedStatement pst = con.prepareStatement("SELECT Customer_ID from Project.customer");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data = rs.getInt(1);
            }
            if (vip >= 0 || vip <= 3) {

            } else {
                Random rand = new Random();
                vip = rand.nextInt(4);
            }

            PreparedStatement pst2 = con.prepareStatement(
                    "INSERT INTO Project.customer(Customer_ID, VIP_level, NIP, Organization_name, Fname, Lname, Country, Postcode, City, Address, Phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst2.setInt(1, data - 1);
            pst2.setInt(2, vip);
            pst2.setInt(3, nip);
            pst2.setString(4, company);
            pst2.setString(5, name);
            pst2.setString(6, surname);
            pst2.setString(7, country);
            pst2.setString(8, postcode);
            pst2.setString(9, city);
            pst2.setString(10, address);
            pst2.setString(11, phone);
            ResultSet var = pst2.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(data - 1);

    }

    public static void addProduct(int brandId, int categoryId, String name, String desc, float Price) {
        try {
            PreparedStatement idSt = con.prepareStatement("select MAX(product.Product_ID) from Project.product;");
            ResultSet rs1 = idSt.executeQuery();
            rs1.next();
            int id = rs1.getInt("max") + 1;
            PreparedStatement pst = con.prepareStatement("INSERT INTO Project.product VALUES (?, ?, ?, ?, ?, ?);");
            pst.setInt(1, id);
            pst.setInt(2, brandId);
            pst.setInt(3, categoryId);
            pst.setString(4, name);
            pst.setString(5, desc);
            pst.setFloat(6, Price);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addBrand(int supplierId, String name, String country) {
        try {
            PreparedStatement idSt = con.prepareStatement("select MIN(brand.Brand_ID) from Project.brand;");
            ResultSet rs1 = idSt.executeQuery();
            rs1.next();
            int id = rs1.getInt("min") - 1;
            PreparedStatement pst = con.prepareStatement("INSERT INTO Project.brand VALUES (?, ?, ?, ?);");
            pst.setInt(1, id);
            pst.setInt(2, supplierId);
            pst.setString(3, name);
            pst.setString(4, country);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addCategory(int departmentID, String name) {
        try {
            PreparedStatement idSt = con.prepareStatement("select MAX(Category.Category_ID) from Project.Category;");
            ResultSet rs1 = idSt.executeQuery();
            rs1.next();
            int id = rs1.getInt("max") + 1;
            PreparedStatement pst = con.prepareStatement("INSERT INTO Project.Category VALUES (?, ?, ?);");
            pst.setInt(1, id);
            pst.setInt(2, departmentID);
            pst.setString(3, name);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addDepartment(String name, String desc) {
        try {
            PreparedStatement idSt = con
                    .prepareStatement("select MAX(department.department_ID) from Project.department;");
            ResultSet rs1 = idSt.executeQuery();
            rs1.next();
            int id = rs1.getInt("max") + 1;
            PreparedStatement pst = con.prepareStatement("INSERT INTO Project.department VALUES (?, ?, ?);");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, desc);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addSupplier(String name, String NIP, String country, String postcode, String city,
            String address, String phone) {
        try {
            PreparedStatement idSt = con
                    .prepareStatement("select MAX(supplier.Supplier_ID) from Project.supplier;");
            ResultSet rs1 = idSt.executeQuery();
            rs1.next();
            int id = rs1.getInt("max") + 1;
            PreparedStatement pst = con
                    .prepareStatement("INSERT INTO Project.supplier VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, NIP);
            pst.setString(4, country);
            pst.setString(5, postcode);
            pst.setString(6, city);
            pst.setString(7, address);
            pst.setString(8, phone);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
