package com.example.hateoasminiproject.domain.repository.specification;

import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    private ProductSpecification(){}

    public static Specification<Product> filterProduct(ProductFilter filter){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getTitle() != null && filter.getTitle().length() > 0) {
                var searchTerm = "%" + filter.getTitle() + "%";
                predicates.add(criteriaBuilder.like(root.get("title"), searchTerm));
            }
            if (filter.getClassification() != null && filter.getClassification().length() > 0) {
                var searchTerm = "%" + filter.getClassification() + "%";
                predicates.add(criteriaBuilder.like(root.get("classification"), searchTerm));
            }
            if (filter.getPrice() != null){
                predicates.add(criteriaBuilder.equal(root.get("price"), filter.getPrice()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

}
}
