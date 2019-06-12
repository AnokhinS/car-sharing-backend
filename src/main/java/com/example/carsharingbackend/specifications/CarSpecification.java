package com.example.carsharingbackend.specifications;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CarSpecification implements Specification<CarEntity> {

    private SearchCriteria criteria;

    public CarSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<CarEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Path path = getPath(root, criteria.getKey());

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(path, criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(path, criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("=")) {
            return builder.equal(path, criteria.getValue());
        }
        return null;
    }

    private Path getPath(Path path, String key) {
        String[] fieldNames = key.split("\\.");
        for (String field : fieldNames) {
            path = path.get(field);
        }
        return path;
    }
}