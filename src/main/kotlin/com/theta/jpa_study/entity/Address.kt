package com.theta.jpa_study.entity

import jakarta.persistence.*

@Entity
@Table(name = "addresses")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val city: String
)
