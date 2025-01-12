package com.theta.jpa_study.join

import com.theta.jpa_study.entity.Order
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
class UserOrderTest @Autowired constructor(
    private val userRepository: UserRepository
) {

    @Test
    fun `사용자와 주문을 저장 및 조회`() {
        // given
        val user = User(name = "Theta", email = "theta@gmail.com")
        val orders = listOf(
            Order(product = "Book", user = user),
            Order(product = "Pen", user = user)
        )

        val userWithOrders = user.copy(orders = orders)

        // when
        val savedUser = userRepository.save(userWithOrders)
        val retrievedUser = userRepository.findById(savedUser.id).orElse(null)

        // then
        assertNotNull(retrievedUser)
        assertEquals(2, retrievedUser.orders.size)
        assertEquals("Book", retrievedUser.orders[0].product)
        assertEquals("Pen", retrievedUser.orders[1].product)
    }
}