package db

import (
	"checkpoint-2/internal/application/repository"
	"checkpoint-2/internal/domain"
	"database/sql"
)

type appointmentDatabase struct {
	db *sql.DB
}

func (a *appointmentDatabase) Post(appointment domain.Appointment) error {
	_, err := a.db.Exec(
		`INSERT INTO appointments
		(name, quantity, code_value, is_published, expiration, price)
		VALUES
		(?, ?, ?, ?, ?, ?)`,
		appointment.Id,
		appointment.Dentist.Id,
		appointment.Patient.Id,
		appointment.AppointmentDate,
	)
	if err != nil {
		return err
	}
	return nil
}

func (a *appointmentDatabase) Get(id int) (domain.Appointment, error) {
	var appointment domain.Appointment

	rows, err := a.db.Query(`SELECT * from appointments WHERE id=?`, id)
	if err != nil {
		return domain.Appointment{}, err
	}
	for rows.Next() {
		err := rows.Scan(
			&appointment.Id,
			&appointment.Dentist.Id,
			&appointment.Patient.Id,
			&appointment.AppointmentDate,
		)
		if err != nil {
			return domain.Appointment{}, err
		}
	}
	return appointment, nil
}

func (a *appointmentDatabase) GetAll() ([]domain.Appointment, error) {
	return []domain.Appointment{}, nil
}
func (a *appointmentDatabase) Put(id int, dentist domain.Appointment) error {
	return nil
}
func (a *appointmentDatabase) Patch(id int, dentist domain.Appointment) error {
	return nil
}
func (a *appointmentDatabase) Delete(id int) error {
	return nil
}

func NewAppointmentDatabase(database *sql.DB) repository.AppointmentRepository {
	return &appointmentDatabase{database}
}