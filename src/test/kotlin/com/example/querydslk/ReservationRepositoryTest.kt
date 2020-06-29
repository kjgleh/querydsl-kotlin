package com.example.querydslk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@SpringBootTest
@Transactional
internal class ReservationRepositoryTest {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var reservationRepository: ReservationRepository

    @Test
    fun test() {
        val name = UUID.randomUUID().toString()
        val res = Reservation(
            name = name
        )
        em.persist(res)

        // Act
        val result = reservationRepository.findByName(name)

        assertThat(result).isEqualTo(res);
        assertThat(result!!.name).isEqualTo(res.name);
    }
}
