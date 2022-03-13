package com.example.hateoasminiproject.domain.repository.specification;

import com.example.hateoasminiproject.domain.filter.UserFilter;
import com.example.hateoasminiproject.domain.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    private UserSpecification(){}

    public static Specification<User> filterUser(UserFilter filter) {
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filter.getName() != null && filter.getName().length() > 0) {
                String searchTerm = "%" + filter.getName() + "%";
                predicates.add(criteriaBuilder.like(root.get("name"), searchTerm));
            }
            if(filter.getEmail() != null && filter.getEmail().length() > 0) {
                String searchTerm = "%" + filter.getEmail() + "%";
                predicates.add(criteriaBuilder.like(root.get("name"), searchTerm));
            }
            if(filter.getAge() != null) {
                predicates.add(criteriaBuilder.equal(root.get("age"), filter.getAge()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}
