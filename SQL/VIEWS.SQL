CREATE OR REPLACE VIEW PRODUCTS AS 
SELECT Product_ID, Name, Price from Project.product;

CREATE OR REPLACE VIEW CATEGORIES AS 
SELECT Category_ID, Name  from Project.category;

CREATE OR REPLACE VIEW DEPARTMENTS AS 
SELECT Department_ID, Name, Description  from Project.department;

CREATE OR REPLACE VIEW BRANDS AS 
SELECT Brand_ID, Name, Manufacture_country from Project.brand;

CREATE OR REPLACE VIEW SUPPLIERS AS 
SELECT Supplier_ID, Name, NIP, Country, Postcode, Address, Phone from Project.supplier;

CREATE OR REPLACE VIEW CUSTOMERS AS
SELECT Customer_ID, VIP_level, Organization_name, Fname, Lname, Country, Postcode, City, Address, Phone from Project.customer;

CREATE OR REPLACE VIEW EMPLOYEES AS
SELECT Employee_ID, Fname, Lname, Country, Postcode, City, Address, Phone from Project.employee;

 