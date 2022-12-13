package product

import (
	"errors"

	"github.com/bootcamp-go/Consignas-Go-Web.git/internal/domain"
	"github.com/bootcamp-go/Consignas-Go-Web.git/internal/pkg/store"
)

type Repository interface {
	GetAll() []domain.Product
	GetByID(id int) (domain.Product, error)
	SearchPriceGt(price float64) []domain.Product
	Create(p domain.Product) (domain.Product, error)
	Update(id int, p domain.Product) (domain.Product, error)
	Delete(id int) error
}

type repository struct {
	s store.Store
}

// NewRepository cria um novo repositório
func NewRepository(s store.Store) Repository {
	return &repository{s}
}

// GetAll devolve todos os produtos
func (r *repository) GetAll() []domain.Product {
	return r.s.Products
}

// GetByID busca um produto pelo seu ID
func (r *repository) GetByID(id int) (domain.Product, error) {
	product := r.s.Search(id); if product != nil {
		return *product, nil
	}
	return domain.Product{}, errors.New("product not found")

}

// SearchPriceGt pesquisa produtos por preço maior ou igual ao preço fornecido
func (r *repository) SearchPriceGt(price float64) []domain.Product {
	var products []domain.Product
	for _, product := range r.s.Products {
		if product.Price > price {
			products = append(products, product)
		}
	}
	return products
}

// Create adiciona um novo produto
func (r *repository) Create(p domain.Product) (domain.Product, error) {
	if !r.validateCodeValue(p.CodeValue) {
		return domain.Product{}, errors.New("code value already exists")
	}
	p.Id = len(r.s.Products) + 1
	r.s.Products = append(r.s.Products, p)
	return p, nil
}

// validateCodeValue valida que o código não existe na lista de produtos
func (r *repository) validateCodeValue(codeValue string) bool {
	for _, product := range r.s.Products {
		if product.CodeValue == codeValue {
			return false
		}
	}
	return true
}

// Delete exclui um produto
func (r *repository) Delete(id int) error {
	ok := r.s.Remove(id); if ok {
		return nil
	}
	return errors.New("product not found")
}

// Update atualiza um produto
func (r *repository) Update(id int, p domain.Product) (domain.Product, error) {
	for _, product := range r.s.Products {
		if product.Id == id {
			if !r.validateCodeValue(p.CodeValue) && product.CodeValue != p.CodeValue {
				return domain.Product{}, errors.New("code value already exists")
			}
			productUpdated := r.s.Update(id, p)
			return *productUpdated, nil
		}
	}
	return domain.Product{}, errors.New("product not found")
}
