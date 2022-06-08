DELIMITER $$
CREATE PROCEDURE sp_Gera_Parcela(IN pImporte decimal(10,2), pDataInicio date, pParcelas int)
BEGIN
	DECLARE valorParcela decimal(10,2) default 1;
    DECLARE nParcela int;
    DECLARE dataParcela date;
    DECLARE e_code varchar(1000);
    DECLARE e_msg varchar(1000);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN 
		GET DIAGNOSTICS CONDITION 1
        e_code = RETURNED_SQLSTATE, e_msg = MESSAGE_TEXT;
        SELECT e_code, e_msg;
	END;
    
    SET nParcela = 1;
    SET valorParcela = (pImporte / pParcelas);
    
    DROP TABLE IF EXISTS tmpParcelas;
    CREATE TEMPORARY TABLE tmpParcelas
		(nrParcela int, data date, importe decimal(10,2));
	
    SET dataParcela = pDataInicio;
    WHILE nParcela <= pParcelas DO
		INSERT INTO tmpParcelas (nrParcela, data, importe) VALUES
        (nParcela, fn_diaUtil(dataParcela), valorParcela);
	SET dataParcela = Date_add(dataParcela,Interval 30 day);
		SET nParcela = vParcecla + 1;
	END WHILE;
    SELECT nrParcela as 'Nr. da Parcela',
    DATE_FORMAT(data, '%d/%m/%Y') as 'Data da Parcela',
    importe as 'Valor da Parcela'
FROM tmpParcelas;
END $$
DELIMITER ;
    