package db

import (
	"database/sql"
	"io/ioutil"
	"strings"

	_ "github.com/go-sql-driver/mysql"
	log "github.com/sirupsen/logrus"
)

const (
	dbType = "mysql"
	uriConnection = "user:@tcp(localhost:3306)/my_db"
	scriptPath = "./config/initial_script.sql"
)

func Connection() (*sql.DB, error) {
	d, err := sql.Open(dbType, uriConnection)
	if err != nil {
		log.WithFields(log.Fields{
			"db_type":           dbType,
			"addressConnection": uriConnection,
		}).WithError(err).Info("error trying to connect the database")
		return nil, err
	}

	if err := d.Ping(); err != nil {
		log.WithFields(log.Fields{
			"db_type":        dbType,
			"addressConnection": uriConnection,
		}).WithError(err).Info("error trying to ping the database")
		return nil, err
	}
	file, err := ioutil.ReadFile(scriptPath)
	if err != nil {
		log.WithFields(log.Fields{
			"scriptPath":        scriptPath,
		}).WithError(err).Info("error trying to read initial script")
	}

	requests := strings.Split(string(file), ";")
	for _, request := range requests {
		_, err = d.Exec(request);
	}

	return d, nil
}