package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.Type;
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
    public Iterable<Type> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public Type get(@PathVariable int id) {
        Type foundType = service.get(id);
        if (foundType != null)
            return foundType;
        else
            throw new ObjectNotFoundException();
    }

    @PostMapping
    public Type add(@RequestBody Type type) throws RuntimeException {
        try {
            return service.create(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ObjectAlreadyExistsException();
    }

    @PutMapping
    public Type update(@RequestBody Type type) throws RuntimeException {
        Type found = service.get(type.getId());
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
    public void delete(@RequestBody Type object) {
        Type found = service.get(object.getId());
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(object);
    }

}
