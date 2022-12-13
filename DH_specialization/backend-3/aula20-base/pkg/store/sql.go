package store

import (
	"database/sql"
	"fmt"
	"log"

	"github.com/bootcamp-go/consignas-go-db.git/internal/domain"
	_ "github.com/go-sql-driver/mysql"
)

type sqlStore struct {
	db *sql.DB
	*jsonStore
}

func NewSQLStore() StoreInterface {
	database, err := sql.Open("mysql", "user:@tcp(localhost:3306)/my_db")
	if err != nil {
		log.Fatalln(err)
	}

	if err := database.Ping(); err != nil {
		log.Fatalln(err)
	}

	return &sqlStore{
		db: database,
	}
}

func (s *sqlStore) Delete(id int) error {
	_, err := s.db.Exec("DELETE FROM products WHERE id=?", id)
	if err != nil {
		return err
	}

	return nil
}

func (s *sqlStore) Read(id int) (domain.Product, error) {
	product := domain.Product{}

	rows, err := s.db.Query(`SELECT * from products WHERE id=?`, id)
	if err != nil {
		return domain.Product{}, err
	}
	for rows.Next() {
		err := rows.Scan(
			&product.Id,
			&product.Name,
			&product.Quantity,
			&product.CodeValue,
			&product.IsPublished,
			&product.Expiration,
			&product.Price,
		)
		if err != nil {
			return domain.Product{}, err
		}
	}
	return product, nil
}

func (s *sqlStore) Update(product domain.Product) error {
	fmt.Println("updating product")
	_, err := s.db.Exec(
		`UPDATE products
		SET
			name = ?,
			quantity = ?,
			code_value = ?,
			is_published = ?,
			expiration = ?,
			price = ?
		WHERE id = ?`,
		product.Name,
		product.Quantity,
		product.CodeValue,
		product.IsPublished,
		product.Expiration,
		product.Price,
		product.Id,
	)
	if err != nil {
		fmt.Println(err)
		return err
	}
	return nil
}

func (s *sqlStore) Exists(codeValue string) bool {
	return false
}

func (s *sqlStore) Create(product domain.Product) error {
	_, err := s.db.Exec(
		`INSERT INTO products
		(name, quantity, code_value, is_published, expiration, price)
		VALUES
		(?, ?, ?, ?, ?, ?)`,
		product.Name,
		product.Quantity,
		product.CodeValue,
		product.IsPublished,
		product.Expiration,
		product.Price,
	)
	if err != nil {
		return err
	}
	return nil
}
