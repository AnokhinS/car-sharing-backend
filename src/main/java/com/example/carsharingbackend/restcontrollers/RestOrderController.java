package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/restapi/orders")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestOrderController {
    private final OrderService service;

    public RestOrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Order> list(@RequestParam(required = false) String user) {
        return user == null ? service.findAll() : service.findAllByUserId(Long.parseLong(user));
    }

    @GetMapping("{id}")
    public Order get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public Order add(@RequestBody Order order) {
        return service.create(order);
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody Order order) {
        order.setId(id);
        service.update(order);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
