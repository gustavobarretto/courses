package domain

type Product struct {
	Id          int     `json:"id,omitempty"`
	Name        string  `json:"name,omitempty" binding:"required"`
	Quantity    int     `json:"quantity,omitempty" binding:"required"`
	CodeValue   string  `json:"code_value,omitempty" binding:"required"`
	IsPublished bool    `json:"is_published,omitempty"`
	Expiration  string  `json:"expiration,omitempty" binding:"required"`
	Price       float64 `json:"price,omitempty" binding:"required"`
}
