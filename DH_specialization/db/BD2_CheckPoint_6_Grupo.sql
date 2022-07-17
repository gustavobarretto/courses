DELIMITER $$
CREATE PROCEDURE sp_distribuir_vacinas(IN data_de_inicio date, IN data_fim date, OUT message VARCHAR(300))
BEGIN
	SELECT c.Nome as cidade_nome, COUNT(p.cidade_idcidade) as quantidade_pessoas, COUNT(p.dosesSolicitadas) as total_doses
	FROM cidade as c 
	INNER JOIN pessoa as p
	ON c.id = p.cidade_idCidade
	GROUP BY c.Nome;
END $$
DELIMITER ;

-- Grupo: Gustavo Barretto, Eduardo Araújo, Vitor Galbier, Marcelo Nader, Silas Medeiros
