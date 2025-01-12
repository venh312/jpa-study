package com.theta.jpa_study.dto.response

import com.theta.jpa_study.entity.User

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val orders: List<String>
) {
    companion object {
        fun fromEntity(user: User): UserResponse {
            return UserResponse(
                id = user.id,
                name = user.name,
                email = user.email,
                orders = user.orders.map { it.product }
            )
        }
    }
}


