package com.digitalbooking.backend.domain.repository.specification;

import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Category_;
import com.digitalbooking.backend.domain.model.City_;
import com.digitalbooking.backend.domain.model.Product;
import com.digitalbooking.backend.domain.model.Product_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class ProductSpecification {

    private ProductSpecification(){}

    public static Specification<Product> filterProduct(ProductFilter filter) {
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filter.getCity_name() != null && filter.getCity_name().length() > 0) {
                String searchTerm = "%" + filter.getCategory_name() + "%";
                predicates.add(criteriaBuilder.like(root
                        .get(Product_.city)
                        .get(City_.name), searchTerm));
            }
            if(filter.getCategory_id() != null && filter.getCategory_id().length() > 0) {
                String searchTerm = filter.getCategory_id();
                predicates.add(criteriaBuilder.like(root
                        .get(Product_.category)
                        .get(Category_.ID), filter.getCategory_id()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
