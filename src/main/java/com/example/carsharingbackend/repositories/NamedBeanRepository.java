package com.example.carsharingbackend.repositories;

import com.example.carsharingbackend.entity.common.NamedBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.Optional;

@NoRepositoryBean
public interface NamedBeanRepository<E extends NamedBean> extends JpaRepository<E, Long> {
    Collection<E> findByOrderByName();

    Collection<E> findByNameStartsWithIgnoreCaseOrderByName(String startsWith);

    Optional<E> findByNameIgnoreCase(String name);

}
