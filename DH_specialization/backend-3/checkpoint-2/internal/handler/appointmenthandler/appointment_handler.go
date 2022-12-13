package appointmenthandler

import (
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/domain"
	"checkpoint-2/pkg/web"
	"errors"
	"reflect"
	"strconv"

	"github.com/gin-gonic/gin"
)

type appointmentHandler struct{
	appointmentGroup	gin.RouterGroup
	appointmentService usecase.Appointment
}

func (d *appointmentHandler) ConfigureAppointmentRouter() {
	d.appointmentGroup.POST("", d.post)
	d.appointmentGroup.GET(":id", d.get)
	d.appointmentGroup.GET("", d.getAll)
	d.appointmentGroup.PUT(":id", d.put)
	d.appointmentGroup.PATCH(":id", d.patch)
	d.appointmentGroup.DELETE(":id", d.delete)
}

func (d *appointmentHandler) post(ctx *gin.Context) {
	var appointment domain.Appointment
	err := ctx.ShouldBindJSON(&appointment); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}
	err = d.appointmentService.Post(appointment); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.Status(201)
}

func (d *appointmentHandler) get(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	appointment, err := d.appointmentService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(appointment, domain.Appointment{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	ctx.JSON(200, appointment)
}

func (d *appointmentHandler) getAll(ctx *gin.Context) {
	appointments, err := d.appointmentService.GetAll(); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.JSON(200, appointments)
}

func (d *appointmentHandler) put(ctx *gin.Context) {
	var appointment domain.Appointment
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	err = ctx.ShouldBindJSON(&appointment); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}

	appointment, err = d.appointmentService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(appointment, domain.Appointment{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.appointmentService.Put(idConverted, appointment); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)
}
func (d *appointmentHandler) patch(ctx *gin.Context) {

}

func (d *appointmentHandler) delete(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	appointment, err := d.appointmentService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(appointment, domain.Dentist{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.appointmentService.Delete(idConverted); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)

}

func NewAppointmentHandler(routerGroup *gin.RouterGroup, service usecase.Appointment) appointmentHandler {
	return appointmentHandler{*routerGroup, service}
}