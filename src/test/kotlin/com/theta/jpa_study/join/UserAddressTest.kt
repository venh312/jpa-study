package com.theta.jpa_study.join

import com.theta.jpa_study.entity.Address
import com.theta.jpa_study.entity.User
import com.theta.jpa_study.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
@Transactional
class UserAddressTest @Autowired constructor(
        private val userRepository: UserRepository
) {

    @Test
    fun `사용자와 주소를 저장 및 조회`() {
        // given
        val address = Address(street = "123 Main st", city = "Seoul")
        val user = User(name = "theta", email = "theta@gmail.com", address = address)

        val savedUser = userRepository.save(user)
        val retrievedUser = userRepository.findById(savedUser.id).orElse(null)

        assertNotNull(retrievedUser)
        assertNotNull(retrievedUser.address)
        assertEquals("123 Main st", retrievedUser.address?.street)
        assertEquals("Seoul", retrievedUser.address?.city)
    }

}
