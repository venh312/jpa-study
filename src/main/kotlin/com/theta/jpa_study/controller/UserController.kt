package com.theta.jpa_study.controller

import com.theta.jpa_study.dto.request.CreateUserRequest
import com.theta.jpa_study.dto.response.UserResponse
import com.theta.jpa_study.entity.Order
import com.theta.jpa_study.entity.User
import com.theta.jpa_study.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUserWithOrders(@RequestBody request: CreateUserRequest): UserResponse {
        return userService.createUserWithOrders(request)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserResponse? {
        return userService.getUserById(id)
    }
}