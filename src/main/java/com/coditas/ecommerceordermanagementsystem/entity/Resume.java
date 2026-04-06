package com.coditas.ecommerceordermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "skill")
    private String skill;

    @Column(name = "experience")
    private float experience;

    @Column(name = "education")
    private String education;

    @Column(name = "resumeText")
    private String resumeText;
}
