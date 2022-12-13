package application

type Application interface {
	Setup() error
	Run() error
}