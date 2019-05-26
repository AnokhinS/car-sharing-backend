package com.example.carsharingbackend.restcontrollers;


import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.services.TransmissionService;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/restapi/transmissions")
//@PreAuthorize("hasAuthority('ADMIN')")
public class RestTransmissionController {
    private final TransmissionService service;

    public RestTransmissionController(TransmissionService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<TransmissionEntity> list(@RequestParam(required = false) String startsWith) {
        System.out.println(startsWith);
        return service.list(startsWith);
    }

    @GetMapping("{id}")
    public TransmissionEntity get(@PathVariable long id) {
        return service.get(id);
    }

    @PostMapping
    public TransmissionEntity add(@RequestBody TransmissionEntity transmission) {
        return service.create(transmission);
    }

    @PutMapping("{id}")
    public TransmissionEntity update(@PathVariable long id, @RequestBody TransmissionEntity transmission) {
        transmission.setId(id);
        return service.update(transmission);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
