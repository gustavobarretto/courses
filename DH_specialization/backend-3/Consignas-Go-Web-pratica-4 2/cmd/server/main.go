package main

import (
	"log"
	"net/http"
	"os"
	"strings"

	"github.com/bootcamp-go/Consignas-Go-Web.git/cmd/server/handler"
	"github.com/bootcamp-go/Consignas-Go-Web.git/internal/pkg/store"
	"github.com/bootcamp-go/Consignas-Go-Web.git/internal/product"
	"github.com/gin-gonic/gin"
	"github.com/joho/godotenv"
)

func main() {
	err := godotenv.Load()
	if err != nil {
		log.Fatal("Error loading .env file")
	}

	store := store.NewStore()
	store.Init()

	repo := product.NewRepository(store)
	service := product.NewService(repo)
	productHandler := handler.NewProductHandler(service)

	r := gin.Default()

	r.Use(func(ctx *gin.Context) {
		tokenReceived := ctx.GetHeader("SECRET_TOKEN")
		token := os.Getenv("TOKEN")

		if strings.EqualFold(token, tokenReceived) {
			ctx.Next()
			return
		}

		ctx.AbortWithStatus(http.StatusUnauthorized)
	})

	r.GET("/ping", func(c *gin.Context) { c.String(200, "pong") })
	products := r.Group("/products")
	{
		products.GET("", productHandler.GetAll())
		products.GET(":id", productHandler.GetByID())
		products.GET("/search", productHandler.Search())
		products.POST("", productHandler.Post())
		products.DELETE(":id", productHandler.Delete())
		products.PATCH(":id", productHandler.Patch())
		products.PUT(":id", productHandler.Put())
	}
	r.Run(":8080")
}

// loadProducts carrega os produtos do arquivo .json

