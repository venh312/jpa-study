package com.theta.jpa_study.service

import com.theta.jpa_study.dto.request.CreateUserRequest
import com.theta.jpa_study.dto.response.UserResponse
import com.theta.jpa_study.entity.Order
import com.theta.jpa_study.entity.User
import com.theta.jpa_study.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserId(id: Long): User {
        return userRepository.findById(id).orElse(null)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @Transactional
    fun createUserWithOrders(request: CreateUserRequest): UserResponse {
        // User 생성
        val user = User(
            name = request.name,
            email = request.email
        )

        // 먼저 User 저장
        val savedUser = userRepository.save(user)

        // Order 생성 및 관계 설정
        val orders = request.orders.map { Order(product = it, user = savedUser) }
        val userWithOrders = savedUser.copy(orders = orders)

        // 다시 User 저장 (Order는 CascadeType.ALL에 의해 자동 저장)
        val finalUser = userRepository.save(userWithOrders)

        return UserResponse.fromEntity(finalUser)
    }

    @Transactional(readOnly = true)
    fun getUserById(id: Long): UserResponse? {
        val user = userRepository.findById(id).orElse(null) ?: return null
        return UserResponse.fromEntity(user)
    }
}