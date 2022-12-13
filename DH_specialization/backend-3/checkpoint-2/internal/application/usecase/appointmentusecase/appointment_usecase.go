package appointmentusecase

import (
	"checkpoint-2/internal/application/repository"
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/domain"

	log "github.com/sirupsen/logrus"
)

type appointmentService struct {
	repository repository.AppointmentRepository
}

func (d *appointmentService) Post(appointment domain.Appointment) error {
	err := d.repository.Post(appointment); if err != nil {
		log.WithError(err).Info("error creating appointment")
		return err
	}
	return nil
}

func (d *appointmentService) Get(id int) (domain.Appointment, error) {
	appointment, err := d.repository.Get(id); if err != nil {
		log.WithError(err).Info("error getting appointment")
		return domain.Appointment{}, err
	}
	return appointment, nil
}

func (d *appointmentService) GetAll() ([]domain.Appointment, error) {
	appointments, err := d.repository.GetAll(); if err != nil {
		log.WithError(err).Info("error getting all appointments")
		return nil, err
	}
	return appointments, nil
}

func (d *appointmentService) Put(id int, appointment domain.Appointment) error {
	err := d.repository.Put(id, appointment); if err != nil {
		log.WithError(err).Info("error putting the appointment")
		return err
	}
	return nil
}

func (d *appointmentService) Patch(id int, appointment domain.Appointment) error {
	err := d.repository.Patch(id, appointment); if err != nil {
		log.WithError(err).Info("error patching the appointment")
		return err
	}
	return nil
}

func (d *appointmentService) Delete(id int) error {
	err := d.repository.Delete(id); if err != nil {
		log.WithError(err).Info("error deleting the appointment")
		return err
	}
	return nil
}

func NewAppointmentService(r repository.AppointmentRepository) usecase.Appointment {
	return &appointmentService{r}
}