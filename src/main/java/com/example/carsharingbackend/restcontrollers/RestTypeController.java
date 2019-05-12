package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.Type;
import com.example.carsharingbackend.services.TypeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restapi/types")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestTypeController {
    private final TypeService service;

    public RestTypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Type> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public Type get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    public Type add(@RequestBody Type type) throws RuntimeException {
        return service.create(type);
    }

    @PutMapping
    public Type update(@RequestBody Type type) throws RuntimeException {
        return service.update(type);
    }

    @DeleteMapping
    public void delete(@RequestBody Type object) {
        service.delete(object);
    }

}
