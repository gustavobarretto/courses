DELIMITER $$

CREATE FUNCTION idade(birth_date date)
RETURNS tinyint deterministic

BEGIN
	DECLARE result tinyint;
    SET result = (SELECT TIMESTAMPDIFF(YEAR, birth_date, CURDATE()));
    RETURN result;
END $$
DELIMITER ;

ALTER TABLE empleados
ADD compleanos tinyint;

DELIMITER $$
CREATE PROCEDURE atualizar_idade()
BEGIN
	UPDATE empleados
    SET compleanos = (SELECT idade(empleados.fecha_nacimiento) as idade);
END $$

CALL atualizar_idade();

SELECT * FROM empleados;