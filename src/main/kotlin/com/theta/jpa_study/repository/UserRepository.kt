package com.theta.jpa_study.repository

import com.theta.jpa_study.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}