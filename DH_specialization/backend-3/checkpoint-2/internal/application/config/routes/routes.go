package routes

import (
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/handler/appointmenthandler"
	"checkpoint-2/internal/handler/dentisthandler"
	"checkpoint-2/internal/handler/patienthandler"

	"github.com/gin-gonic/gin"
)

type routes struct{
	server *gin.Engine
	dentistService usecase.Dentist
	patientService usecase.Patient
	appointmentService usecase.Appointment
}

func (r *routes) SetupRoutes() {
	
	dentistGroup := r.server.Group("/dentists")
	patientGroup := r.server.Group("/patients")
	appointmentGroup := r.server.Group("/appointments")

	routesDentist := dentisthandler.NewDentistHandler(dentistGroup, r.dentistService)
	routesDentist.ConfigureDentistRouter()

	routesPatient := patienthandler.NewPatientHandler(patientGroup, r.patientService)
	routesPatient.ConfigurePatientRouter()

	routesAppointment := appointmenthandler.NewAppointmentHandler(appointmentGroup, r.appointmentService)
	routesAppointment.ConfigureAppointmentRouter()

}

func NewRoutes(server *gin.Engine, dentistService usecase.Dentist, patientService usecase.Patient, appointmentService usecase.Appointment) routes {
	return routes{
		server,
		dentistService,
		patientService,
		appointmentService,
	}
}