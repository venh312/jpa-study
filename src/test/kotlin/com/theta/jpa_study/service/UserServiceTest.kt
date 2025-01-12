package com.theta.jpa_study.service

import com.theta.jpa_study.entity.Address
import com.theta.jpa_study.entity.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserServiceTest @Autowired constructor(
      private val userService: UserService
) {

    @Test
    fun `사용자 저장 및 조회`() {
        val user = User(name = "Theta", email = "Theta@gmail.com")
        val saveUser = userService.saveUser(user)

        assertNotNull(saveUser.id)
        assertEquals("Theta", saveUser.name)
        assertEquals("Theta@gmail.com", saveUser.email)
    }
}