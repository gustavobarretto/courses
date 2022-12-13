package patienthandler

import (
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/domain"
	"checkpoint-2/pkg/web"
	"errors"
	"reflect"
	"strconv"

	"github.com/gin-gonic/gin"
)

type patientHandler struct{
	patientGroup	gin.RouterGroup
	patientService usecase.Patient
}

func (d *patientHandler) ConfigurePatientRouter() {
	d.patientGroup.POST("", d.post)
	d.patientGroup.GET(":id", d.get)
	d.patientGroup.GET("", d.getAll)
	d.patientGroup.PUT(":id", d.put)
	d.patientGroup.PATCH(":id", d.patch)
	d.patientGroup.DELETE(":id", d.delete)
}

func (d *patientHandler) post(ctx *gin.Context) {
	var patient domain.Patient
	err := ctx.ShouldBindJSON(&patient); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}
	err = d.patientService.Post(patient); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.Status(201)
}

func (d *patientHandler) get(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	dentist, err := d.patientService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(dentist, domain.Patient{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	ctx.JSON(200, dentist)
}

func (d *patientHandler) getAll(ctx *gin.Context) {
	dentists, err := d.patientService.GetAll(); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.JSON(200, dentists)
}

func (d *patientHandler) put(ctx *gin.Context) {
	var patient domain.Patient
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	err = ctx.ShouldBindJSON(&patient); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}

	patient, err = d.patientService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(patient, domain.Patient{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.patientService.Put(idConverted, patient); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)
}
func (d *patientHandler) patch(ctx *gin.Context) {

}

func (d *patientHandler) delete(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	patient, err := d.patientService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(patient, domain.Patient{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.patientService.Delete(idConverted); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)

}

func NewPatientHandler(routerGroup *gin.RouterGroup, service usecase.Patient) patientHandler {
	return patientHandler{*routerGroup, service}
}