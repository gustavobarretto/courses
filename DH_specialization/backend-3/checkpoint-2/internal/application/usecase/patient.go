package usecase

import (
	"checkpoint-2/internal/domain"
)

type Patient interface {
	Post(domain.Patient) error
	Get(int) (domain.Patient, error)
	GetAll() ([]domain.Patient, error)
	Put(int, domain.Patient) error
	Patch(int, domain.Patient) error
	Delete(int) error
}
