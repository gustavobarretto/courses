USE musimundos;
SHOW INDEX FROM canciones;
CREATE INDEX idx_nome ON canciones(nombre);

CREATE FULLTEXT INDEX idx_titulo ON empleados(titulo);
SHOW INDEX FROM empleados;

CREATE FULLTEXT INDEX idx_title ON employee(Title);


USE adventureworks;
SELECT Title, COUNT(ContactID) as qtd
FROM employee
WHERE MATCH(Title) AGAINST('Production Techinician')
GROUP BY Title;

SELECT Title
FROM employee
WHERE MATCH(Title) AGAINST('+Marketing Manager' IN BOOLEAN MODE);