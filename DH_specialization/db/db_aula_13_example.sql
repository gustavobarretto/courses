USE dhemprestimos;

DELIMITER $$

CREATE FUNCTION calcIdade(birth_date Date)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE age INT
    SET age = TIMESTAMPDIFF(YEAR, birth_date, CURDATE())
    RETURN age;
END
DELIMITER ; 

$$ DELIMITER ;

CREATE PROCEDURE sp_emprestimos(IN codClient INT, IN valor FLOAT, IN dataInit Date, IN qntParcelas INT, tipo VARCHAR(20)
BEGIN
	DECLARE birth_date
    DECLARE age
    
    SET birth_date = SELECT clientes.data_nasc WHERE idclientes = codClient;
    SET age = calcIdade(birth_date)
    IF (age > 18 AND < 80)
		
    
    
END $$
DELIMITER ;