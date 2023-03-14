package com.pws.APIDoc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "gender", length = 10)
    private String gender;
    @Column(name = "email", length = 100, unique = true)
    private String email;
    @Column(name = "phone_number", length = 12, unique = true)
    private long phoneNumber;

}
