package com.hackaboss.nota.Entity;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
