package com.example.carsharingbackend.services;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.exceptions.ObjectAlreadyExistsException;
import com.example.carsharingbackend.exceptions.ObjectNotFoundException;
import com.example.carsharingbackend.repositories.NamedBeanRepository;
import com.example.carsharingbackend.utils.StringUtils;

import java.util.Collection;


public abstract class NamedBeanService<E extends NamedBean> {
    private NamedBeanRepository<E> repository;

    public NamedBeanService(NamedBeanRepository<E> repository) {
        this.repository = repository;
    }

    public Collection<E> getAllOrdered() {
        return repository.findByOrderByName();
    }

    public Collection<E> getAllStartsWith(String startsWith) {
        return repository.findByNameStartsWithIgnoreCaseOrderByName(startsWith);
    }

    public Collection<E> list(String startsWith) {
        if(startsWith==null){
            return getAllOrdered();
        }
        return getAllStartsWith(startsWith);
    }

    public abstract NamedBean newBean();

    public E get(long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    protected boolean alreadyExist(String name) {
        try {
            getByName(name);
            return true;
        } catch (ObjectNotFoundException e) {
            return false;
        }
    }

    public E getByName(String name) {
        return repository.findByNameIgnoreCase(name).orElseThrow(ObjectNotFoundException::new);
    }

    public E create(E object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        object.setId(0L);
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public E update(E object) {
        if (alreadyExist(object.getName()))
            throw new ObjectAlreadyExistsException();
        get(object.getId());
        object.setName(StringUtils.firstToUpper(object.getName()));
        return repository.save(object);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}