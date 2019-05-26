package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.services.CarService;
import com.example.carsharingbackend.specifications.CarFilter;
import com.example.carsharingbackend.specifications.CarSpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public Collection<CarEntity> list(@RequestParam(value = "costFrom", required = false) String costFrom, @RequestParam(value = "costTo", required = false) String costTo,
                                      @RequestParam(value = "firms", required = false) String firms) {
        CarSpecificationsBuilder builder = new CarSpecificationsBuilder();
        if(costFrom!=null){
            builder.with("costPerDay", ">", costFrom,false);
        }
        if(costTo!=null){
            builder.with("costPerDay", "<", costTo,false);
        }
        if(firms!=null){
            List<String> flist= Arrays.asList(firms.split(","));
                        flist.forEach(e->{
                            builder.with("firm.name", "=", e,true);
            });
        }

        Specification<CarEntity> spec = builder.build();
        return service.findAll(spec);
    }

    @GetMapping("{id}")
    public CarEntity get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public CarEntity add(@RequestBody CarEntity car) {
        return service.create(car);
    }

    @PutMapping
    public CarEntity update(@RequestBody CarEntity car) {
        CarEntity found = service.get(car.getId());
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
    public void delete(@RequestBody CarEntity object) {
        CarEntity found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object);
    }

}
