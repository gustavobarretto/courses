USE adventureworks;

-- Where
-- 1. Mostre as pessoas  cuja segunda letra do sobrenome é “a”.
-- Tabela: Contact 
-- Campos:FirstName, MiddleName e  LastName 
SELECT contact.FirstName as first_name, contact.MiddleName as middle_name, contact.LastName as last_name
FROM contact
WHERE contact.MiddleName LIKE '_a%';

-- 2. Mostre o título e o nome concatenado com o sobrenome das pessoas que têm como "Títle" os valores "Mr." e “Ms”
-- Tabela: Contact 
-- Campos: Title, FirstName, LastName
SELECT CONCAT(contact.FirstName, " ", contact.LastName) as full_name, contact.Title as title
FROM contact
WHERE contact.Title LIKE "Ms%" OR contact.Title LIKE "Mr%";

-- 3. Mostre os nomes  e o nr. de série dos produtos cujo número  do produto começa com “AR” ou “BE” ou “DC”.
-- Tabela: Product 
-- Campos: Name, ProductNumber
SELECT product.Name as product_name, product.ProductNumber as serial_number
FROM product
WHERE 
product.ProductNumber LIKE "AR%" OR
product.ProductNumber LIKE "BE%" OR
product.ProductNumber LIKE "DC%";

-- 4. Mostrar pessoas cujos nomes têm um C como o primeiro caractere e o segundo caractere não é "O" nem "E".
-- Tabela: Contact 
-- Campos: ContactID, FirstName, LastName 
SELECT contact.FirstName as first_name, contact.LastName as last_name, contact.ContactID as id_contact
FROM contact
WHERE contact.FirstName LIKE "C%" AND
contact.FirstName NOT LIKE "_O%" AND
contact.FirstName NOT LIKE "_E%";

-- 5. Mostre todos os produtos cujo preço de tabela está entre 400 e 500 
-- Tabela: Product 
-- Campos: Name, ListPrice 
SELECT product.Name as product_name, product.ListPrice as product_price
FROM product
WHERE product.ListPrice BETWEEN 400 AND 500;

-- 6. Mostre todos os funcionários que nasceram entre 1960 e 1980 e cujos anos de nascimento sejam pares.
-- Tabela: Employee 
-- Campos: EmployeeID, ContactID, Title, BirthDate
SELECT employee.EmployeeID as id, employee.ContactID as id_contact, employee.Title as employee_title, employee.BirthDate as birth_date
FROM employee
WHERE EXTRACT(YEAR FROM employee.BirthDate) BETWEEN 1960 AND 1980
AND EXTRACT(YEAR FROM employee.BirthDate) % 2 = 0;

-- Operadores & joins
-- Mostre o código, data de entrada e horas de férias dos funcionários que entraram a partir do ano 2000.
-- Tabela: Employee 
-- Campos: EmployeeID,  Title, HireDate, VacationHours 
SELECT 
employee.EmployeeID as id,
employee.Title as employee_title,
employee.HireDate as hired_date,
employee.VacationHours as vacation_hours
FROM employee
WHERE EXTRACT(YEAR FROM employee.HireDate) >= 2000;

-- Mostre o nome, número do produto, preço de tabela e o preço de tabela acrescido 
-- de 10% dos produtos cuja data final de venda seja anterior a hoje.
-- Tabela: Product 
-- Campos: Name, ProductNumber, ListPrice, SellEndDate
SELECT
product.Name as product_name,
product.ProductNumber as serial_number,
ROUND(product.ListPrice * 1.1, 2) as product_price,
product.SellEndDate as sold_date
FROM product
WHERE product.sellEndDate < NOW();
 
-- Group By
-- 1. Mostre o número de funcionários por ano de nascimento.
-- Tabela: Employee 
-- Campo: BirthDate 
SELECT 
COUNT(EXTRACT(YEAR FROM employee.BirthDate)) as qnt_employees_by_year,
EXTRACT(YEAR FROM employee.BirthDate) as birth_year
FROM employee
GROUP BY EXTRACT(YEAR FROM employee.BirthDate);

-- 2. Mostre o preço médio dos produtos por ano de início da venda.
-- Tabela: Product 
-- Campos: productID,  ListPrice, SellStartDate
SELECT
ROUND(AVG(product.ListPrice), 2) as average_price,
EXTRACT(YEAR FROM product.SellStartDate) as year_start_sell
FROM product
GROUP BY EXTRACT(YEAR FROM product.SellStartDate)
ORDER BY EXTRACT(YEAR FROM product.SellStartDate) ASC;

-- 3. Mostre os produtos e o total vendido de cada um deles, ordenados pelo total vendido.
-- Tabela: SalesOrderDetail 
-- Campos: ProductID, LineTotal
SELECT 
product.ProductID as product_id,
ROUND(SUM(salesorderdetail.LineTotal), 2) as total_sale
FROM product
LEFT JOIN salesorderdetail
ON product.ProductID = salesorderdetail.ProductID 
GROUP BY product.ProductID
ORDER BY total_sale DESC;

-- 4.Mostre a média vendida por fatura. 
-- Tabela: SalesOrderDetail 
-- Campos: SalesOrderID, LineTotal 
SELECT
product.ProductID as product_id,
ROUND(AVG(salesorderdetail.LineTotal), 2) as average_sale
FROM product
LEFT JOIN salesorderdetail
ON product.ProductID = salesorderdetail.ProductID
GROUP BY product.ProductID
ORDER BY average_sale DESC;

-- Having 
-- 1. Mostre subcategorias para produtos que têm dois ou mais produtos que custam menos de US$ 200. 
-- Tabela: Product 
-- Campos: ProductSubcategoryID, ListPrice 
SELECT
productsubcategory.ProductSubcategoryID as category_id,
productsubcategory.Name as subcategory_name,
COUNT(product.ProductID) as total_products
FROM productsubcategory
INNER JOIN
product
ON productsubcategory.ProductSubcategoryID = product.ProductSubcategoryID
WHERE product.ListPrice > 200
GROUP BY productsubcategory.Name
HAVING COUNT(product.ListPrice) >= 2;

-- Selet to conference the previously query
SELECT product.ListPrice as price
FROM product
WHERE product.ProductSubcategoryID = 17;

-- 2.Mostre todos os códigos de subcategoria existentes juntamente com 
-- a quantidade de produtos cujo preço de tabela é superior a US$ 100 
-- e o preço médio é inferior a US$ 300. 
-- Tabela: Product 
-- Campos: ProductID, ProductSubcategoryID, ListPrice 
SELECT
productsubcategory.ProductSubcategoryID as subcategory_id,
productsubcategory.Name as subcategory_name,
COUNT(product.ProductID) as total_products
FROM productsubcategory
INNER JOIN
product
ON productsubcategory.ProductSubcategoryID = product.ProductSubcategoryID
WHERE product.ListPrice > 100
GROUP BY productsubcategory.Name
HAVING AVG(product.ListPrice) < 300;
-- conferir dps


-- Joins 
-- 1. Mostre os preços de venda dos produtos em
-- que o valor é inferior ao preço de tabela 
-- recomendado para esse produto ordenado pelo nome do produto. 
-- Tabelas: SalesOrderDetail, Product 
-- Campos: ProductID, Name, listPrice, UnitPrice
SELECT DISTINCT
product.ProductID as product_id,
product.Name as product_name,
ROUND(salesorderdetail.UnitPrice, 2) as unit_price_on_sale,
ROUND(product.ListPrice, 2) as list_price
FROM product
INNER JOIN
salesorderdetail
ON product.ProductID = salesorderdetail.ProductID
WHERE salesorderdetail.UnitPrice < product.ListPrice
ORDER BY product.Name;

-- 2. Mostre todos os produtos que têm o mesmo preço. 
-- O código e o nome de cada um dos dois produtos e o 
-- preço de ambos devem ser apresentados em pares. Ordenar por preço decrescente.
-- Tabela: Product 
-- Campos: ProductID, Name,  ListPrice
SELECT
p1.ProductID as product_id_p1,
p1.Name as product_name_p1,
p1.ListPrice as product_price_p1,
p2.ProductID as product_id_p2,
p2.Name as product_name_p2,
p2.ListPrice as product_price_p2
FROM product p1
INNER JOIN
product p2
ON p1.ListPrice = p2.ListPrice
WHERE p1.ProductID NOT LIKE p2.ProductID
AND p1.ListPrice != 0 AND p2.ListPrice != 0
GROUP BY p1.ProductID
ORDER BY p1.ListPrice DESC;

-- 3. Mostre o nome dos produtos e fornecedores ordenados por nome de fornecedor decrescente.
-- Tabelas: Product, ProductVendor, Vendor 
-- Campos: Name ,ProductID, BusinessEntityID, ProductSubcategoryID 
SELECT
product.ProductID as product_id,
product.Name as product_name,
vendor.Name as vendor_name
FROM product
INNER JOIN productvendor
ON product.ProductID = productvendor.ProductID
INNER JOIN vendor
ON productvendor.VendorID = vendor.VendorID
ORDER BY vendor.Name DESC; 

-- 4. Mostre todas as pessoas —nome e sobrenome— e se forem funcionários, mostre também o id de login, caso contrário, mostre null.
-- Tabelas: Contact, Employee 
-- Campos: FirstName, LastName, LoginID
SELECT 
CONCAT(c.FirstName, " ", c.LastName) as contact_full_name,
e.LoginID as login_id
FROM contact c
LEFT JOIN employee e
ON c.ContactID = e.ContactID
ORDER BY e.LoginID DESC;