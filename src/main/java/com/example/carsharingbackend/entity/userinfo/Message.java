package com.example.carsharingbackend.entity.userinfo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate date;

    public Message() {
    }

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        read = false;
        date = LocalDate.now();
    }
}
