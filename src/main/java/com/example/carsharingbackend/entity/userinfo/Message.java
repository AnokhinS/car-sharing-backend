package com.example.carsharingbackend.entity.userinfo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private boolean read;

    private Timestamp date;

}
