package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import com.example.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.services.TypeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restapi/messages")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestMessageController {
    private final TypeService service;

    public RestMessageController(TypeService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<TypeEntity> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public TypeEntity get(@PathVariable int id) {
        TypeEntity foundType = service.get(id);
        if (foundType != null)
            return foundType;
        else
            throw new ObjectNotFoundException();
    }

    @PostMapping
    public TypeEntity add(@RequestBody TypeEntity type) throws RuntimeException {
        try {
            return service.create(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ObjectAlreadyExistsException();
    }

    @PutMapping
    public TypeEntity update(@RequestBody TypeEntity type) throws RuntimeException {
        TypeEntity found = service.get(type.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            return service.update(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody TypeEntity object) {
        TypeEntity found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object.getId());
    }

}
