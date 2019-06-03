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

    @Column(name = "first_name")
    @Size(min = 2, max = 15)
    @Pattern(regexp = "[a-zA-ZА-Яа-я]+")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 15)
    @Pattern(regexp = "[a-zA-ZА-Яа-я]+")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Size(min = 4, max = 20)
    private String password;

    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    public User() {
    }

    public User(long id) {
        this.id = id;
    }


    public User(@Size(min = 2, max = 15) @Pattern(regexp = "[a-zA-ZА-Яа-я]+") String firstName, @Size(min = 2, max = 15) @Pattern(regexp = "[a-zA-ZА-Яа-я]+") String lastName, @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$") String email, @Size(min = 4, max = 20) String password, boolean active, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

}
