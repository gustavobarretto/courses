-- 1. Precisamos criar auditoria para a tabela 
-- onde as parcelas são salvas. Precisamos saber
-- quem modifica e quem exclui parcelas. Crie 
-- uma solução implementando triggers.
USE dhemprestimos;

DELIMITER $$

CREATE TRIGGER trigger_auditoria_update
BEFORE UPDATE ON dhemprestimos.parcelas
FOR EACH ROW
BEGIN
	SET new.userInsert = (SELECT CURRENT_USER());
    SET new.dataInsert = now();
END $$

CREATE TRIGGER trigger_auditoria_delete
BEFORE DELETE ON dhemprestimos.parcelas
FOR EACH ROW
BEGIN
	SET new.userInsert = (SELECT CURRENT_USER());
    SET new.dataInsert = now();
END $$

DELIMITER ;


-- 2. Precisamos adicionar na SP  sp_Gera_Parcela, 
-- um manipulador para todas essas SQLEXCEPTIONS. 
-- Se pegarmos um SQLEXCEPTION temos que realizar um ROLLBACK da transação.

DELIMITER $$

CREATE PROCEDURE sp_gera_parcela()
BEGIN 
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'Error Exception - Error SQL';
	END;
    
    INSERT dhemprestimos.parcelas(idparcelas, idemprestimo, data, importe) 
    VALUES
    (1, 1, now(), 2000.00);
    
END $$

DELIMITER ;

-- 3. Crie uma consulta que retorne todas as 
-- parcelas vencidas no próximo dia útil e que,
-- além disso, o valor pago até o momento seja 
-- inferior a 30% do total do empréstimo.
