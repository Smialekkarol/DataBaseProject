CREATE SCHEMA Project;

CREATE TABLE Project.STORE (
                Store_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Postcode VARCHAR(6) NOT NULL,
                City VARCHAR NOT NULL,
                Country VARCHAR NOT NULL,
                Address VARCHAR NOT NULL,
                Phone VARCHAR NOT NULL,
                CONSTRAINT store_id PRIMARY KEY (Store_ID)
);


CREATE TABLE Project.VIP (
                VIP_level INTEGER NOT NULL,
                Discount REAL NOT NULL,
                CONSTRAINT vip_level PRIMARY KEY (VIP_level)
);
COMMENT ON COLUMN Project.VIP.Discount IS '% of discount';


CREATE TABLE Project.CUSTOMER (
                Customer_ID INTEGER NOT NULL,
                VIP_level INTEGER NOT NULL,
                NIP VARCHAR(10),
                Organization_name VARCHAR,
                Fname VARCHAR NOT NULL,
                Lname VARCHAR NOT NULL,
                Country VARCHAR NOT NULL,
                Postcode VARCHAR(6) NOT NULL,
                City VARCHAR NOT NULL,
                Address VARCHAR NOT NULL,
                Phone VARCHAR NOT NULL,
                CONSTRAINT customer_id PRIMARY KEY (Customer_ID)
);


CREATE TABLE Project.CUSTOMER_DATA (
                Customer_ID INTEGER NOT NULL,
                Username VARCHAR NOT NULL,
                Password VARCHAR NOT NULL
);


CREATE TABLE Project.EMPLOYEE (
                Employee_ID INTEGER NOT NULL,
                Fname VARCHAR NOT NULL,
                Lname VARCHAR NOT NULL,
                Country VARCHAR NOT NULL,
                Postcode VARCHAR(6) NOT NULL,
                City VARCHAR NOT NULL,
                Address VARCHAR NOT NULL,
                Phone VARCHAR NOT NULL,
                CONSTRAINT employee_id PRIMARY KEY (Employee_ID)
);


CREATE TABLE Project.EMPLOYEE_DATA (
                Employee_ID INTEGER NOT NULL,
                Username VARCHAR NOT NULL,
                Password VARCHAR NOT NULL
);


CREATE TABLE Project.DEPARTMENT (
                Department_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Description VARCHAR,
                CONSTRAINT department_id PRIMARY KEY (Department_ID)
);


CREATE TABLE Project.SUPPLIER (
                Supplier_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                NIP VARCHAR(10) NOT NULL,
                Country VARCHAR NOT NULL,
                Postcode VARCHAR(6) NOT NULL,
                City VARCHAR NOT NULL,
                Address VARCHAR NOT NULL,
                Phone VARCHAR NOT NULL,
                CONSTRAINT supplier_id PRIMARY KEY (Supplier_ID)
);


CREATE TABLE Project.CATEGORY (
                Category_ID INTEGER NOT NULL,
                Department_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                CONSTRAINT category_id PRIMARY KEY (Category_ID)
);


CREATE TABLE Project.BRAND (
                Brand_ID INTEGER NOT NULL,
                Supplier_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Manufacture_country VARCHAR NOT NULL,
                CONSTRAINT brand_id PRIMARY KEY (Brand_ID)
);


CREATE TABLE Project.PRODUCT (
                Product_ID INTEGER NOT NULL,
                Brand_ID INTEGER NOT NULL,
                Category_ID INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Description VARCHAR,
                Price REAL NOT NULL,
                CONSTRAINT product_id PRIMARY KEY (Product_ID)
);


CREATE TABLE Project.SALE_TRANSACTION (
                Sale_transaction_ID INTEGER NOT NULL,
                Customer_ID INTEGER NOT NULL,
                Store_ID INTEGER NOT NULL,
                Product_ID INTEGER NOT NULL,
                Quantity INTEGER NOT NULL,
                Sale_date DATE NOT NULL,
                Status VARCHAR NOT NULL,
                CONSTRAINT sale_transaction_id PRIMARY KEY (Sale_transaction_ID)
);
COMMENT ON COLUMN Project.SALE_TRANSACTION.Status IS 'if order was completly finished then true else false';


CREATE TABLE Project.BASKET (
                Basket_ID INTEGER NOT NULL,
                Sale_transaction_ID INTEGER NOT NULL,
                Total REAL NOT NULL,
                CONSTRAINT basket_id PRIMARY KEY (Basket_ID)
);


CREATE TABLE Project.MAGAZINE (
                Magazine_ID INTEGER NOT NULL,
                Basket_ID INTEGER NOT NULL,
                Customer_ID INTEGER NOT NULL,
                Employee_ID INTEGER NOT NULL,
                CONSTRAINT magazine_id PRIMARY KEY (Magazine_ID)
);


ALTER TABLE Project.SALE_TRANSACTION ADD CONSTRAINT store_sale_transaction_fk
FOREIGN KEY (Store_ID)
REFERENCES Project.STORE (Store_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.CUSTOMER ADD CONSTRAINT vip_customer_fk
FOREIGN KEY (VIP_level)
REFERENCES Project.VIP (VIP_level)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.SALE_TRANSACTION ADD CONSTRAINT customer_sale_transaction_fk
FOREIGN KEY (Customer_ID)
REFERENCES Project.CUSTOMER (Customer_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.CUSTOMER_DATA ADD CONSTRAINT customer_klient_dane_fk
FOREIGN KEY (Customer_ID)
REFERENCES Project.CUSTOMER (Customer_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.MAGAZINE ADD CONSTRAINT customer_magazine_fk
FOREIGN KEY (Customer_ID)
REFERENCES Project.CUSTOMER (Customer_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.EMPLOYEE_DATA ADD CONSTRAINT employee_employee_data_fk
FOREIGN KEY (Employee_ID)
REFERENCES Project.EMPLOYEE (Employee_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.MAGAZINE ADD CONSTRAINT employee_magazine_fk
FOREIGN KEY (Employee_ID)
REFERENCES Project.EMPLOYEE (Employee_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.CATEGORY ADD CONSTRAINT department_category_fk
FOREIGN KEY (Department_ID)
REFERENCES Project.DEPARTMENT (Department_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.BRAND ADD CONSTRAINT supplier_brand_fk
FOREIGN KEY (Supplier_ID)
REFERENCES Project.SUPPLIER (Supplier_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.PRODUCT ADD CONSTRAINT category_product_fk
FOREIGN KEY (Category_ID)
REFERENCES Project.CATEGORY (Category_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.PRODUCT ADD CONSTRAINT brand_product_fk
FOREIGN KEY (Brand_ID)
REFERENCES Project.BRAND (Brand_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.SALE_TRANSACTION ADD CONSTRAINT product_sale_transaction_fk
FOREIGN KEY (Product_ID)
REFERENCES Project.PRODUCT (Product_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.BASKET ADD CONSTRAINT sale_transaction_basket_fk
FOREIGN KEY (Sale_transaction_ID)
REFERENCES Project.SALE_TRANSACTION (Sale_transaction_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Project.MAGAZINE ADD CONSTRAINT basket_magazine_fk
FOREIGN KEY (Basket_ID)
REFERENCES Project.BASKET (Basket_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;