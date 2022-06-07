DELIMITER $$

CREATE FUNCTION faturas_por_cliente(client_id int, init_date date, final_date date)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
	DECLARE result DECIMAL(5,2);
    SET result = (
    SELECT SUM(facturas.total) as total_faturas
    FROM facturas
    WHERE facturas.id_cliente LIKE client_id
    AND facturas.fecha_factura BETWEEN init_date AND final_date
    GROUP BY facturas.id_cliente);
    RETURN result;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE cliente_faturamento(IN date_init date, IN date_final date)
BEGIN
	SELECT clientes.*,
    CASE 
		WHEN faturas_por_cliente(clientes.id, date_init, date_final) = 0 THEN "sem dados"
        WHEN faturas_por_cliente(clientes.id, date_init, date_final) IS NULL THEN "sem dados"
        ELSE faturas_por_cliente(clientes.id, date_init, date_final)
		END AS total_faturas
	FROM clientes;
END $$
DELIMITER ;


DELIMITER $$

CREATE FUNCTION calc_tax(p FLOAT, t FLOAT)
RETURNS FLOAT
DETERMINISTIC
BEGIN
	DECLARE result FLOAT;
    SET result = p * ((t / 100) + 1);
    RETURN result;
END $$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE calculate_tax(
IN price FLOAT, IN tax FLOAT,
OUT product_price FLOAT, OUT tax_applied FLOAT, OUT product_with_tax FLOAT)
BEGIN
	SET product_price = price;
    SET tax_applied = tax;
    SET product_with_tax = calc_tax(price, tax);
END $$
DELIMITER ;

CALL calculate_tax(5000, 21, @product_value, @tax_applied, @total_value);
SELECT @product_value, @tax_applied, @total_value;
	
	