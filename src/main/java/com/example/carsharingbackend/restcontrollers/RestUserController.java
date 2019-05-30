package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restapi/users")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestUserController {
    private final UserService service;

    public RestUserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<User> list(@RequestParam(value = "startsWith", required = false) String startsWith) {
        return service.findAll(startsWith);
    }

    @GetMapping("{id}")
    public User get(@PathVariable long id) {
        User found = service.get(id);
        if (found != null)
            return found;
        else
            throw new ObjectNotFoundException();
    }

    @PostMapping
    public User add(@RequestBody User user) throws RuntimeException {
        try {
            return service.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ObjectAlreadyExistsException();
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody User user) throws RuntimeException {
        User found = service.get(id);
        if (found == null)
            throw new ObjectNotFoundException();
        try {
            service.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        User found = service.get(id);
        if (found == null)
            throw new ObjectNotFoundException();
        service.delete(id);
    }

}
