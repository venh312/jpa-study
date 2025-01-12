package com.theta.jpa_study.dto.request

data class CreateUserRequest(
    val name: String,
    val email: String,
    val orders: List<String>
)
