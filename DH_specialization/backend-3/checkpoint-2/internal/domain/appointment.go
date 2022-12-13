package domain

type Appointment struct {
	Id int
	Patient Patient
	Dentist Dentist
	AppointmentDate string
}