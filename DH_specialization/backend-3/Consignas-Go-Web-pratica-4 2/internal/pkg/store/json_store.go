package store

import (
	"encoding/json"
	"os"

	"github.com/bootcamp-go/Consignas-Go-Web.git/internal/domain"
)

type Store struct {
	Products []domain.Product
}

func NewStore() Store {
	return Store{}
}

func (s *Store) Init() {
	loadProducts("./products.json", &s.Products)
}

func (s *Store) Search(id int) *domain.Product {
	for _, product := range s.Products {
		if product.Id == id {
			return &product
		}
	}
	return nil
}

func (s *Store) Update(id int, p domain.Product) *domain.Product {
	for index, product := range s.Products {
		if product.Id == id {
			p.Id = product.Id
			memoryAllocated := &s.Products[index]
			*memoryAllocated = p
			s.replace()
			return &p
		}
	}
	return nil
}

func (s *Store) Remove(id int) bool {
	for index, product := range s.Products {
		if product.Id == id {
			s.Products = append(s.Products[:index], s.Products[index+1:]...)
			s.replace()
			return true
		}
	}
	return false
}

func loadProducts(path string, list *[]domain.Product) {
	file, err := os.ReadFile(path)
	if err != nil {
		panic(err)
	}
	err = json.Unmarshal([]byte(file), &list)
	if err != nil {
		panic(err)
	}
}

func (s *Store) replace() {
	b, err := json.Marshal(s.Products)
	if err != nil {
		panic(err)
	}

	f, err := os.OpenFile("./products.json", os.O_TRUNC, 0755)
	if err != nil {
		panic(err)
	}
	f.Write(b)
}