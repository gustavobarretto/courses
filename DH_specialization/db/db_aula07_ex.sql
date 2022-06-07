-- Em um banco de dados qualquer, 
-- vamos gerar uma SP que recebe 
-- diferentes números como parâmetros 
-- em um varchar separados por “;”.  
-- Use LOOP para percorrê-los. 
-- Importante: no final sempre 
-- coloque um “;”. Um exemplo, 
-- '10;66;138;37;-72;0,5;'. 
-- A SP retornará 2 parâmetros: a soma 
-- total entre eles e sua média. 
-- Só precisamos somar e calcular a média 
-- dos números que são positivos. 
-- Valide o que foi dito acima com um CASE. 
-- Assumimos que pelo menos 1 número é sempre recebido. 

USE EMarket;

DELIMITER $$

CREATE PROCEDURE atividade (IN array_numbers LONGTEXT, OUT average_value FLOAT, OUT total_value FLOAT)
BEGIN
    DECLARE n FLOAT;
    DECLARE counter INT;
    SET n = 0;
    SET counter = 0;
    SET total_value = 0;
    SET n = SUBSTRING_INDEX(array_numbers, ";", 1);
	WHILE (LOCATE(";", array_numbers) != 0)
		DO 
			SET n = SUBSTRING_INDEX(array_numbers, ";", 1);
			SET total_value = total_value + n;
			SET array_numbers = RIGHT(array_numbers, CHAR_LENGTH(array_numbers) - LOCATE(";", array_numbers));
            SET counter = counter + 1;
	END WHILE;
    SET average_value = total_value / counter;
    SELECT @average_value as inside_procedure_avg, @total_value as inside_procedure_total_value;
END $$

DELIMITER ;

SET @variable_test = (SELECT GROUP_CONCAT(Produtos.PrecoUnitario SEPARATOR ";") as array_numbers FROM Produtos GROUP BY Produtos.Descontinuado); 
SELECT @variable_test as test;
CALL atividade(@variable_test, @average_value, @total_value);

SELECT ROUND(@average_value, 2) as average, ROUND(@total_value, 2) as total;




		