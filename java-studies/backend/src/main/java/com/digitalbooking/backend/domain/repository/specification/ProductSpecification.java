package com.digitalbooking.backend.domain.repository.specification;

import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class ProductSpecification {

    private ProductSpecification(){}

    public static Specification<Product> filterProduct(ProductFilter filter) {
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filter.getName() != null && filter.getName().length() > 0) {
                String searchTerm = "%" + filter.getName() + "%";
                predicates.add(criteriaBuilder.like(root.get("name"), searchTerm));
            }
            if(filter.getCategory() != null && filter.getCategory().length() > 0) {
                String searchTerm = "%" + filter.getCategory() + "%";
                predicates.add(criteriaBuilder.like(root.get("category"), searchTerm));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
