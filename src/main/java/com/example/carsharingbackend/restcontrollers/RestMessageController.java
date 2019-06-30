//package com.example.carsharingbackend.restcontrollers;
//
//
//import com.example.carsharingbackend.entity.carinfo.TypeEntity;
//import com.example.carsharingbackend.entity.userinfo.Message;
//import com.example.carsharingbackend.exceptions.ObjectAlreadyExistsException;
//import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
//import com.example.carsharingbackend.services.MessageService;
//import com.example.carsharingbackend.services.TypeService;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/restapi/messages")
////@PreAuthorize("hasAuthority('ADMIN')")
//public class RestMessageController {
//
//    MessageService service;
//
//    public RestMessageController(MessageService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public Iterable<TypeEntity> list() {
//        return service.getAllOrdered();
//    }
//
//    @GetMapping("{id}")
//    public TypeEntity get(@PathVariable int id) {
//        TypeEntity foundType = service.get(id);
//        if (foundType != null)
//            return foundType;
//        else
//            throw new ObjectNotFoundException();
//    }
//
//    @PostMapping
//    public TypeEntity add(@RequestBody Message type) throws RuntimeException {
//        try {
//            return service.create(type);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        throw new ObjectAlreadyExistsException();
//    }
//
//
//
//}
