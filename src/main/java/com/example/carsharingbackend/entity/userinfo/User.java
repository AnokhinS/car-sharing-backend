package com.example.carsharingbackend.entity.userinfo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Size(min = 2, max = 15)
    @Pattern(regexp = "[a-zA-ZА-Яа-я]+", message = "Введите имя без пробелов")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")
    @Column(name = "email")
    private String email;
    @Size(min = 4, max = 20)
    @Column(name = "password")
    private String password;
    @Pattern(regexp = "^(\\+7|8)\\d{10}$", message = "Формат +7XXXXXXXXXX либо 8XXXXXXXXXX")
    @Column(name = "phone")
    private String phone;
    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Message> messages;

    public User() {
    }
}
