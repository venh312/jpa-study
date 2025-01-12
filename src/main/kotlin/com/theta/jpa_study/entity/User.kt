package com.theta.jpa_study.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = false)
    val email: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id") // 외래 키 설정
    val address: Address? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val orders: List<Order> = mutableListOf()
)