package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.services.CarService;
import com.example.carsharingbackend.specifications.CarSpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


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
                                      @RequestParam(value = "firms", required = false) String firms, @RequestParam(value = "types", required = false) String types,
                                      @RequestParam(value = "transmissions", required = false) String transmissions,
                                      @RequestParam(value = "yearFrom", required = false) String yearFrom, @RequestParam(value = "yearTo", required = false) String yearTo
    ) {
        CarSpecificationsBuilder builder = new CarSpecificationsBuilder();
        builder.with("costPerDay", ">", costFrom, false);
        builder.with("costPerDay", "<", costTo, false);
        builder.with("year", ">", yearFrom, false);
        builder.with("year", "<", yearTo, false);

        if (firms != null) {
            List<String> flist = Arrays.asList(firms.split(","));
            flist.forEach(e -> {
                builder.with("firm.name", "=", e, true);
            });
        }
        if (types != null) {
            List<String> tlist = Arrays.asList(types.split(","));
            tlist.forEach(e -> {
                builder.with("type.name", "=", e, true);
            });
        }
        if (transmissions != null) {
            List<String> trlist = Arrays.asList(transmissions.split(","));
            trlist.forEach(e -> {
                builder.with("transmission.name", "=", e, true);
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

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody CarEntity car) {
        CarEntity found = service.get(id);
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            service.update(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        CarEntity found = service.get(id);
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(id);
    }

}
