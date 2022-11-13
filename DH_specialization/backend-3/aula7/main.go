package main

import (
	"fmt"
	"os"
)

var categories = CreateCategoryData()

func main() {

	CSVCategories, err := CreateFile("categorias"); if err != nil {
		fmt.Printf("error creating category file: %v", err)
		return
	}
	err = WriteCategoriesDataOnFile(CSVCategories, categories); if err != nil {
		fmt.Printf("error writing rows on categories file: %v", err)
		return
	}

	estimativeSliceByCategory := []float64{
		CalculateEstimativeByCategory(categories[0].ProductList),
		CalculateEstimativeByCategory(categories[1].ProductList),
		CalculateEstimativeByCategory(categories[2].ProductList),
	}
	err = CreateEstimativeFile(
		[]string{
			categories[0].Name,
			categories[1].Name,
			categories[2].Name,
		},
		estimativeSliceByCategory,
	); if err != nil {
		fmt.Printf("error creating estimative file: %v", err)
		return
	}
}

func CreateFile(fileName string) (*os.File, error) {
	path := fmt.Sprintf("./output/%s.csv", fileName)
	file, err := os.OpenFile(path, os.O_WRONLY|os.O_CREATE, 0600); if err != nil {
		return nil, fmt.Errorf("error open this file - %w", err)
	}
	return file, nil
}

func WriteCategoriesDataOnFile(file *os.File, data []Category) error {
	for _, row := range data {
		_, err := file.WriteString(CreateCategoryRow(row)); if err != nil {
			return fmt.Errorf("error creating row - %w", err)
		}
	}
	return nil
}

func CreateCategoryRow(category Category) string {
	return fmt.Sprintf(
		"%d,%s,%v\n",
		category.ID,
		category.Name,
		category.ProductList, 
	)
}

func CalculateEstimativeByCategory(products []Product) float64 {
	var finalEstimative float64
	for _, product := range products {
		finalEstimative += (float64(product.ActualQuantity) * product.ActualPrice)
	}
	return finalEstimative
}

func CreateEstimativeFile(categories []string, estimatives []float64) error {
	estimativeFile, err := CreateFile("estimativas"); if err != nil {
		return err
	}
	err = CreateEstimativeHeader(estimativeFile); if err != nil {
		return err
	} 
	for index, category := range categories {
		err = CreateEstimativeRow(
				category,
				estimatives[index],
				estimativeFile,
			); if err != nil {
			return err
		}
	}
	return nil
}

func CreateEstimativeHeader(file *os.File) error {
	_, err := file.WriteString("Categoria,EstimadoPorCategoria\n"); if err != nil {
		return fmt.Errorf("error creating estimative header: %w", err)
	}
	return nil
}

func CreateEstimativeRow(category string, finalEstimative float64, file *os.File) error {
	_, err := file.WriteString(fmt.Sprintf("%s,%.2f\n", category, finalEstimative)); if err != nil {
		return err
	}
	return nil
}

type Product struct {
	ID             int
	Name           string
	ActualPrice    float64
	ActualQuantity int
}

type Category struct {
	ID					int
	Name				string
	ProductList	[]Product
}

func CreateCategoryData() []Category {
	createEletrodomesticCategory := Category{
		1,
		"Eletrodoméstico",
		[]Product{
			{
				1,
				"Fogão",
				399.99,
				3,
			},
			{
				2,
				"Geladeira",
				2999.99,
				2,
			},
			{
				3,
				"Microondas",
				499.99,
				7,
			},
			{
				4,
				"Airfryer",
				185.00,
				2,
			},
		},
	}

	createFornitureCategory := Category{
		2,
		"Móveis",
		[]Product{
			{
				1,
				"Mesa",
				799.00,
				1,
			},
			{
				2,
				"Cadeiras",
				45.00,
				4,
			},
			{
				3,
				"Sofá",
				1.599,
				1,
			},
			{
				4,
				"Poltrona",
				199.99,
				2,
			},
		},
	}

	createToolsCategory := Category{
		3,
		"Ferramentas",
		[]Product{
			{
				1,
				"Martelo",
				39.99,
				1,
			},
			{
				2,
				"Parafusos",
				0.39,
				15,
			},
			{
				3,
				"Alicate",
				79.99,
				1,
			},
			{
				4,
				"Arrulea",
				0.75,
				15,
			},
		},
	}

	return []Category{createEletrodomesticCategory, createFornitureCategory, createToolsCategory}
}