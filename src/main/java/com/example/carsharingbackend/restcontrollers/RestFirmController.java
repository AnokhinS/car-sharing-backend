package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.Firm;
import com.example.carsharingbackend.services.FirmService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restapi/firms")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestFirmController {
    private final FirmService service;

    public RestFirmController(FirmService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Firm> list() {
        return service.getAllOrdered();
    }

    @GetMapping("{id}")
    public Firm get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    public Firm add(@RequestBody Firm firm) {
        return service.create(firm);
    }

    @PutMapping
    public Firm update(@RequestBody Firm firm) {
        return service.update(firm);
    }

    @DeleteMapping
    public void delete(@RequestBody Firm object) {
        service.delete(object);
    }

}
