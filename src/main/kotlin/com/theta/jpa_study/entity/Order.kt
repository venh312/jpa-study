package com.theta.jpa_study.entity

import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val product: String,

    @ManyToOne
    @JoinColumn(name = "user_id") // 외래 키
    val user: User? = null
)
