package main

import (
	"errors"
	"fmt"
)

type Product interface {
	CalculatePrice() float64
}

type ProductType struct {
	Price float64
}

type TinyProduct struct {
	ProductType
}

func NewTinyProduct(value float64) Product {
	return &TinyProduct{
		ProductType: ProductType{
			Price: value,
		},
	}
}

func (t *TinyProduct) CalculatePrice() float64 {
	return t.Price
}

type MediumProduct struct {
	ProductType
}

func NewMediumProduct(value float64) Product {
	return &MediumProduct{
		ProductType: ProductType{
			Price: value,
		},
	}
}

func (m *MediumProduct) CalculatePrice() float64 {
	return m.Price * 1.03
}

type BigProduct struct {
	ProductType
}

func NewBigProduct(value float64) Product {
	return &BigProduct{
		ProductType: ProductType{
			Price: value,
		},
	}
}

func (b *BigProduct) CalculatePrice() float64 {
	return (b.Price * 1.06) + 50
}

func NewProduct(size string, price float64) (Product, error) {
	switch size {
	case "T":
		return NewTinyProduct(price), nil
	case "M":
		return NewMediumProduct(price), nil
	case "B":
		return NewBigProduct(price), nil
	}
	return nil, errors.New("Product size not identified")
}

func main() {
	tinyProduct, err := NewProduct("T", 10.0); if err != nil {
		fmt.Println(err.Error())
		return
	}

	mediumProduct, err := NewProduct("M", 10.0); if err != nil {
		fmt.Println(err.Error())
		return
	}

	bigProduct, err := NewProduct("B", 10.0); if err != nil {
		fmt.Println(err.Error())
		return
	}

	fmt.Println("Tiny Product: ", tinyProduct.CalculatePrice())
	fmt.Println("Medium Product: ", mediumProduct.CalculatePrice())
	fmt.Println("Big Product: ", bigProduct.CalculatePrice())
}
