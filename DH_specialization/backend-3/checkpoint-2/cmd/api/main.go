package main

import (
	"checkpoint-2/internal/application/config/server"

	log "github.com/sirupsen/logrus"
)

func main() {
	app := server.NewServer()
	err := app.Setup(); if err != nil {
		log.WithError(err).Panic("error on setup")
	}
	err = app.Run(); if err != nil {
		log.WithError(err).Panic("error running server")
	}
}