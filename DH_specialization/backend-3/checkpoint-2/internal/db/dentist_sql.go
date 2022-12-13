package db

import (
	"checkpoint-2/internal/application/repository"
	"checkpoint-2/internal/domain"
	"database/sql"
)

type dentistDatabase struct {
	db *sql.DB
}

func (d *dentistDatabase) Post(dentist domain.Dentist) error {
	_, err := d.db.Exec(
		`INSERT INTO dentists VALUES
		(?, ?, ?, ?)`,
		dentist.Id,
		dentist.Name,
		dentist.Surname,
		dentist.Registry,
	)
	if err != nil {
		return err
	}
	return nil
}

func (d *dentistDatabase) Get(id int) (domain.Dentist, error) {
	var dentist domain.Dentist

	rows, err := d.db.Query(`SELECT * from dentists WHERE id=?`, id)
	if err != nil {
		return domain.Dentist{}, err
	}
	for rows.Next() {
		err := rows.Scan(
			&dentist.Id,
			&dentist.Name,
			&dentist.Surname,
			&dentist.Registry,
		)
		if err != nil {
			return domain.Dentist{}, err
		}
	}
	return dentist, nil
}

func (d *dentistDatabase) GetAll() ([]domain.Dentist, error) {
	return []domain.Dentist{}, nil
}
func (d *dentistDatabase) Put(id int, dentist domain.Dentist) error {
	return nil
}
func (d *dentistDatabase) Patch(id int, dentist domain.Dentist) error {
	return nil
}
func (d *dentistDatabase) Delete(id int) error {
	return nil
}

func NewDentistDatabase(database *sql.DB) repository.DentistRepository {
	return &dentistDatabase{database}
}