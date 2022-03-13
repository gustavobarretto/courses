package com.example.hateoasminiproject.domain.repository;

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

            if (filter.getName() != null && filter.getName().length() > 0) {
                var searchTerm = "%" + filter.getName() + "%";
                predicates.add(criteriaBuilder.like(root.get("name"), searchTerm));
            }
            if (filter.getEmail() != null && filter.getEmail().length() > 0) {
                var searchTerm = "%" + filter.getName() + "%";
                predicates.add(criteriaBuilder.like(root.get("email"), searchTerm));
            }
            if (filter.getAge() != null){
                predicates.add(criteriaBuilder.equal(root.get("age"), filter.getAge()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

}
}
