package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.services.FirmService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/restapi/firms")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestFirmController {
    private final FirmService service;

    public RestFirmController(FirmService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    public Collection<FirmEntity> list(@RequestParam(required = false) String startsWith) {
        return service.list(startsWith);
    }


    @GetMapping("{id}")
    public FirmEntity get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public FirmEntity add(@RequestBody FirmEntity firm) {
        return service.create(firm);
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody FirmEntity firm) {
        firm.setId(id);
        service.update(firm);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
