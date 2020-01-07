package com.demo.demoProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Date birthday;

    @Column(nullable = false)
    private Date registryTime = Date.valueOf(LocalDate.now());

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
