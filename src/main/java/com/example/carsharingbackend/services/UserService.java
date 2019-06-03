package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.userinfo.Role;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.exceptions.EmailAlreadyExistException;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository userRep) {
        this.repository = userRep;
    }

    public Iterable<User> findAll(String startsWith) {
        if (startsWith == null) {
            startsWith = "";
        }
        return repository.findByEmailStartsWithIgnoreCaseOrderByEmail(startsWith);
    }

    public User get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public User getByEmail(String email) {
        return repository.findByEmailIgnoreCase(email).orElseThrow(ObjectNotFoundException::new);
    }

    private boolean emailExist(String email) {
        try {
            getByEmail(email);
            return true;
        } catch (ObjectNotFoundException e) {
            return false;
        }
    }

    public User create(User user) throws EmailAlreadyExistException {
        if (emailExist(user.getEmail()))
            throw new EmailAlreadyExistException();
        user.setActive(true);
        Role userRole = Role.USER;
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return repository.save(user);
    }

    public void update(User user) {
        get(user.getId());
        repository.save(user);
    }

    public void delete(long id) {
        repository.delete(get(id));
    }
}
