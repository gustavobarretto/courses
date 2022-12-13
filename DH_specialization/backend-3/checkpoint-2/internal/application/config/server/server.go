package server

import (
	"checkpoint-2/internal/application"
	"checkpoint-2/internal/application/config/routes"
	"checkpoint-2/internal/application/usecase/appointmentusecase"
	"checkpoint-2/internal/application/usecase/dentistusecase"
	"checkpoint-2/internal/application/usecase/patientusecase"
	"checkpoint-2/internal/db"
	"database/sql"

	"github.com/gin-gonic/gin"
	log "github.com/sirupsen/logrus"
)

const addr = ":8080"

type server struct {
	app		*gin.Engine
}

func (s *server) Setup() error {

	database, err := s.configureDatabase(); if err != nil {
		log.WithError(err).Error("error when configure the database")
		return err
	}

	dentistDatabase := db.NewDentistDatabase(database)
 	dentistService := dentistusecase.NewDentistService(dentistDatabase)

	patientDatabase := db.NewPatientDatabase(database)
	patientService := patientusecase.NewPatientService(patientDatabase)

	appointmentDatabase := db.NewAppointmentDatabase(database)
	appointmentService := appointmentusecase.NewAppointmentService(appointmentDatabase)

	
	router := routes.NewRoutes(
		s.app,
		dentistService,
		patientService,
		appointmentService,
	)
	
	router.SetupRoutes()

	return nil
}

func (s *server) Run() error {
	err := s.app.Run(addr); if err != nil {
		log.WithFields(log.Fields{
			"port": addr,
		}).WithError(err).Info("error trying to running the server")
	}
	return nil
}

func (s *server) configureDatabase() (*sql.DB, error) {
	database, err := db.Connection(); if err != nil {
		log.WithError(err).Info("database error")
		return nil, err
	}
	return database, nil
}

func NewServer()  application.Application {
	return &server{
		app: gin.Default(),
	}
}