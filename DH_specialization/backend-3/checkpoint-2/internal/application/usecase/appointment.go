package usecase

import (
	"checkpoint-2/internal/domain"
)

type Appointment interface {
	Post(domain.Appointment) error
	Get(int) (domain.Appointment, error)
	GetAll() ([]domain.Appointment, error)
	Put(int, domain.Appointment) error
	Patch(int, domain.Appointment) error
	Delete(int) error
}