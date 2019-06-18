package com.huelismyfuellukehaha.ardvark.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AppUser {
    @Autowired
    BCryptPasswordEncoder

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id;

    String username;
    String password;
}
