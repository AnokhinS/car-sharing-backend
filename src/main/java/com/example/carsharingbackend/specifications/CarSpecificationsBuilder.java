package com.example.carsharingbackend.specifications;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarSpecificationsBuilder {

    private final Map<String, ArrayList<SearchCriteria>> params;

    public CarSpecificationsBuilder() {
        params = new HashMap<>();
    }

    public CarSpecificationsBuilder with(String key, String operation, Object value, boolean isOr) {
        if (value == null) {
            return null;
        }
        if (params.get(key) == null) {
            ArrayList<SearchCriteria> newList = new ArrayList<>();
            newList.add(new SearchCriteria(key, operation, value, isOr));
            params.put(key, newList);
        } else {
            params.get(key).add(new SearchCriteria(key, operation, value, isOr));
        }

        return this;
    }

    public Specification<CarEntity> build() {
        if (params.size() == 0) {
            return null;
        }

        String[] keySet = params.keySet().toArray(new String[0]);
        Specification result = null;

        for (int i = 0; i < keySet.length; i++) {
            String key = keySet[i];
            List<Specification> spec = params.get(key).stream()
                    .map(CarSpecification::new)
                    .collect(Collectors.toList());
            Specification localSpecification;
            if (params.get(key).get(0).isOr()) {
                localSpecification = buildOrSpec(spec);
            } else {
                localSpecification = buildAndSpec(spec);
            }

            if (result == null) {
                result = localSpecification;
            } else {
                result = result.and(localSpecification);
            }
        }
        return result;
    }

    private Specification buildOrSpec(List<Specification> specs) {
        Specification result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result)
                    .or(specs.get(i));
        }
        return result;
    }


    private Specification buildAndSpec(List<Specification> specs) {
        Specification result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result)
                    .and(specs.get(i));
        }
        return result;
    }

}
