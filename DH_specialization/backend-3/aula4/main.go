package main

import "fmt"

type Product struct {
	ID          int
	Name        string
	Price       float64
	Description string
	Category    string
}

var (
	Products = []Product{
		{
			ID:          1,
			Name:        "Monitor Asus",
			Price:       1899.99,
			Description: "Monitor 24 polegadas, 165 hz",
			Category:    "Informática",
		},
		{
			ID:          2,
			Name:        "Mouse Logitech",
			Price:       99.99,
			Description: "Mouse sem fio 16000DPI",
			Category:    "Periférico",
		}, {
			ID:          3,
			Name:        "Teclado Mecânico HyperX",
			Price:       899.99,
			Description: "Teclado mecânico switch blue, tamanho 60%",
			Category:    "Periférico",
		}, {
			ID:          4,
			Name:        "Microfone HyperX",
			Price:       999.99,
			Description: "Microfone quadcast RGB",
			Category:    "Periférico",
		}, {
			ID:          5,
			Name:        "Mousepad Logitech",
			Price:       249.99,
			Description: "Mouse pad emborrachado speed",
			Category:    "Periférico",
		},
	}
)

func (p Product) Save() Product {
	Products = append(Products, p)
	return Products[len(Products)-1]
}

func (p Product) GetAll() []Product {
	return Products
}

func GetById(id int) Product {
	var product Product
	for _, item := range Products {
		if item.ID == id {
			product = item
		}
	}
	return product
}

func main() {
	newProduct := Product{
		ID:          6,
		Name:        "Processador Intel i9 12900",
		Price:       3699.99,
		Description: "Processador Intel i9 da 12a Geração",
		Category:    "Hardware",
	}

	productSaved := newProduct.Save()
	fmt.Println("O produto foi salvo: ", productSaved)

	fmt.Println("Todos os produtos: ")
	fmt.Println(productSaved.GetAll())

	productGetted := GetById(3)
	fmt.Println("Product getted by id 3: ", productGetted)
}
