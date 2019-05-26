package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.TypeEntity;
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
    public Iterable<TypeEntity> list(@RequestParam(required = false) String startsWith) {
        return service.list(startsWith);
    }

    @GetMapping("{id}")
    public TypeEntity get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public TypeEntity add(@RequestBody TypeEntity type) throws RuntimeException {
        return service.create(type);
    }

    @PutMapping("{id}")
    public TypeEntity update(@PathVariable long id,@RequestBody TypeEntity type) {
        type.setId(id);
        return service.update(type);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
