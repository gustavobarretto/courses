package dentisthandler

import (
	"checkpoint-2/internal/application/usecase"
	"checkpoint-2/internal/domain"
	"checkpoint-2/pkg/web"
	"errors"
	"reflect"
	"strconv"

	"github.com/gin-gonic/gin"
)

type dentistHandler struct{
	dentistGroup	gin.RouterGroup
	dentistService usecase.Dentist
}

func (d *dentistHandler) ConfigureDentistRouter() {
	d.dentistGroup.POST("", d.post)
	d.dentistGroup.GET("/:id", d.get)
	d.dentistGroup.GET("", d.getAll)
	d.dentistGroup.PUT(":id", d.put)
	d.dentistGroup.PATCH(":id", d.patch)
	d.dentistGroup.DELETE(":id", d.delete)
}

func (d *dentistHandler) post(ctx *gin.Context) {
	var dentist domain.Dentist
	err := ctx.ShouldBindJSON(&dentist); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}
	err = d.dentistService.Post(dentist); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.Status(201)
}

func (d *dentistHandler) get(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	dentist, err := d.dentistService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(dentist, domain.Dentist{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	ctx.JSON(200, dentist)
}

func (d *dentistHandler) getAll(ctx *gin.Context) {
	dentists, err := d.dentistService.GetAll(); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}
	ctx.JSON(200, dentists)
}

func (d *dentistHandler) put(ctx *gin.Context) {
	var dentist domain.Dentist
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	err = ctx.ShouldBindJSON(&dentist); if err != nil {
		web.Failure(ctx, 400, err)
		return
	}

	dentist, err = d.dentistService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(dentist, domain.Dentist{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.dentistService.Put(idConverted, dentist); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)
}
func (d *dentistHandler) patch(ctx *gin.Context) {

}

func (d *dentistHandler) delete(ctx *gin.Context) {
	id := ctx.Param("id")
	if id == "" {
		web.Failure(ctx, 400, errors.New("no id sent"))
		return
	}

	idConverted, err := strconv.Atoi(id); if err != nil {
		web.Failure(ctx, 400, errors.New("incorrect id sent. must be a number"))
		return
	}

	dentist, err := d.dentistService.Get(idConverted); if err != nil {
		web.Failure(ctx, 500, errors.New("errors getting entity"))
		return
	}

	if reflect.DeepEqual(dentist, domain.Dentist{}) {
		web.Failure(ctx, 404, errors.New("entity not found"))
		return
	}

	err = d.dentistService.Delete(idConverted); if err != nil {
		web.Failure(ctx, 500, err)
		return
	}

	ctx.Status(204)

}

func NewDentistHandler(routerGroup *gin.RouterGroup, service usecase.Dentist) dentistHandler {
	return dentistHandler{*routerGroup, service}
}