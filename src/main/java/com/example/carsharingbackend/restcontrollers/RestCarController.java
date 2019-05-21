package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.Car;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.services.CarService;
import com.example.carsharingbackend.specifications.CarSpecificationsBuilder;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/restapi/cars")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestCarController {
    private final CarService service;


    public RestCarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Car> list(@RequestParam(value = "list", required = false) String search) {
        search="and"+search;
        CarSpecificationsBuilder builder = new CarSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(and|or)(\\w|.+?)([:<>])(?U)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            String g1=matcher.group(1);
            String g2=matcher.group(2);
            String g3=matcher.group(3);
            String g4=matcher.group(4);

            builder.with(g1, g2, g3, g4);
        }
        Specification<Car> spec = builder.build();
        return service.findAll(spec);
    }


    @GetMapping("{id}")
    public Car get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public Car add(@RequestBody Car car) {
        return service.create(car);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        Car found = service.get(car.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            return service.create(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody Car object) {
        Car found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object);
    }

}
