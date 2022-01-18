SELECT DISTINCT * from Project.employee emp 
JOIN Project.employee_data emp_dat on emp.Employee_ID = emp_dat.Employee_ID
WHERE emp_dat.username ='username' AND emp_dat.password = 'password';

SELECT Employee_ID from Project.employee_data e 
WHERE e.username = 'root' AND e.password = 'root';

 


CREATE OR REPLACE FUNCTION addProduct(productId int, brandId int, categoryId int, nme text, descr text, Price float)
RETURNS Integer
$$
BEGIN
INSERT INTO Project.product VALUES (productId, brandId, categoryId, nme, descr, Price);
END;
$$;
LANGUAGE SQL;







DROP FUNCTION addProduct(int, int, int, text, text, numeric);