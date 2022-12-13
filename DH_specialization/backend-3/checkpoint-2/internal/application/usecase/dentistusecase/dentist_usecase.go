package dentistusecase

import (
	"checkpoint-2/internal/application/repository"
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/domain"

	log "github.com/sirupsen/logrus"
)

type dentistService struct {
	repository repository.DentistRepository
}

func (d *dentistService) Post(dentist domain.Dentist) error {
	err := d.repository.Post(dentist); if err != nil {
		log.WithError(err).Info("error creating dentist")
		return err
	}
	return nil
}

func (d *dentistService) Get(id int) (domain.Dentist, error) {
	dentist, err := d.repository.Get(id); if err != nil {
		log.WithError(err).Info("error getting dentist")
		return domain.Dentist{}, err
	}
	return dentist, nil
}

func (d *dentistService) GetAll() ([]domain.Dentist, error) {
	dentists, err := d.repository.GetAll(); if err != nil {
		log.WithError(err).Info("error getting all dentists")
		return nil, err
	}
	return dentists, nil
}

func (d *dentistService) Put(id int, dentist domain.Dentist) error {
	err := d.repository.Put(id, dentist); if err != nil {
		log.WithError(err).Info("error putting the dentist")
		return err
	}
	return nil
}

func (d *dentistService) Patch(id int, dentist domain.Dentist) error {
	err := d.repository.Patch(id, dentist); if err != nil {
		log.WithError(err).Info("error patching the dentist")
		return err
	}
	return nil
}

func (d *dentistService) Delete(id int) error {
	err := d.repository.Delete(id); if err != nil {
		log.WithError(err).Info("error deleting the dentist")
		return err
	}
	return nil
}

func NewDentistService(r repository.DentistRepository) usecase.Dentist {
	return &dentistService{r}
}