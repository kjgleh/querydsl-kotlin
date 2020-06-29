package com.example.querydslk

import com.example.querydslk.QReservation.reservation
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class ReservationRepository(
    val em: EntityManager
) {

    val queryFactory = JPAQueryFactory(em)
    fun findById(reservationId: Long): Reservation? {
        return queryFactory
            .select(reservation)
            .from(reservation)
            .where(reservation.id.eq(reservationId))
            .fetchOne()
    }

    fun findByName(name: String): Reservation? {
        return queryFactory
            .selectFrom(reservation)
            .where(reservation.name.eq(name))
            .fetchOne()
    }

    fun save(reservation: Reservation) {
        em.persist(reservation)
    }
}