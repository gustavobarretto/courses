package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"os"
	"strconv"
	"strings"

	"github.com/gin-gonic/gin"
)

type Post struct {
	UserId			int
	Id					int
	Title				string
	Body				string
}

type User struct {
	Id					int
	Name				string
	Username		string
	Email				string
	Address			Address
	Phone				string
	Website			string
	Company			Company

}

type Address struct {
	Street 			string
	Suite				string
	City				string
	Zipcode			string
	Geo					Geo
}

type Geo struct {
	Lat				string
	Lng 			string
}

type Company struct {
	Name						string
	CatchPhrase			string
	Bs							string 
}

var (
	users []User
	posts []Post
)

func main() {

	app := gin.Default()
	
	UsersBytes, err := os.ReadFile("./users.json")
	if err != nil {
		fmt.Printf("error to read database file: %w", err)
		return 
	}

  err = json.Unmarshal(UsersBytes, &users)
	if err != nil {
		fmt.Printf("error to convert bytes file: %w", err)
		return 
	}

	PostsBytes, err := os.ReadFile("./posts.json")
	if err != nil {
		fmt.Printf("error to read database file: %w", err)
		return 
	}

  err = json.Unmarshal(PostsBytes, &posts)
	if err != nil {
		fmt.Printf("error to convert bytes file: %w", err)
		return 
	}

	app.GET("/users", GetAll)
	app.GET("/users/:id", GetById)
	app.GET("/posts/:id", GetPostsByUser)
	app.GET("/search/:name", GetUsersByName)

	app.Run(":8080")
	
}

func GetAll(ctx *gin.Context) {
	ctx.JSON(http.StatusOK, users) 
}

func GetUsersByName(ctx *gin.Context) {
	name := ctx.Param("name")

	usersFound := []User{}
	for _, user := range users {
		if strings.Contains(strings.ToLower(user.Name), name) {
			usersFound = append(usersFound, user)
		}
	}
	ctx.JSON(http.StatusOK,	usersFound)
}

func GetPostsByUser(ctx *gin.Context) {
	idParam := ctx.Param("id")
	id, err := strconv.Atoi(idParam); if err != nil {
		 fmt.Errorf("failed to parse the id")
		 ctx.JSON(
			http.StatusInternalServerError,
			gin.H{
				"status_code": 500,
				"cause": "Internal Server Error",
				"message": "failed to parse the id",
			},
		 )
		 return
	}

	postsFound := []Post{}
	for _, post := range posts {
		if post.UserId == id {
			postsFound = append(postsFound, post)
		}
	}
	ctx.JSON(http.StatusOK,	postsFound)
}

func userFilter(id int) (User, bool) {
	for _, user := range users {
		if user.Id == id {
			return user, false
		}
	}
	return User{}, true
}

func GetById(ctx *gin.Context) {
	idParam := ctx.Param("id")
	id, err := strconv.Atoi(idParam); if err != nil {
		 fmt.Errorf("failed to parse the id")
		 ctx.JSON(
			http.StatusInternalServerError,
			gin.H{
				"status_code": 500,
				"cause": "Internal Server Error",
				"message": "failed to parse the id",
			},
		 )
		 return
	}
	user, notFound := userFilter(id); if notFound {
		ctx.JSON(
			http.StatusNotFound,
			gin.H{
				"status_code": 404,
				"cause": "Bad Request",
				"message": fmt.Sprintf("user with id %s not found", idParam),
			},
		)
		return
	}
	ctx.JSON(http.StatusOK,	user)
}