package com.groomproject.sharedsidePJT.reservation.repository;

import com.groomproject.sharedsidePJT.baseUtil.Exception.BusinessException;
import com.groomproject.sharedsidePJT.baseUtil.Exception.ExMessage;
import com.groomproject.sharedsidePJT.reservation.dto.ReservationResponse;
import com.groomproject.sharedsidePJT.reservation.entity.QReservation;
import com.groomproject.sharedsidePJT.reservation.entity.Reservation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/07
 */

@Repository
@RequiredArgsConstructor
public class ReservatioinRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public ReservationResponse findByRestaurantId(Long restaurantId) {
        QReservation qReservation = QReservation.reservation;
        Reservation reservation = jpaQueryFactory
                .selectFrom(qReservation)
                .fetchOne();
        try {
            assert reservation != null;
            return reservation.toResponse();
        } catch (Exception e) {
            throw new BusinessException(ExMessage.RESERVATION_NONE_DATA);
        }
    }
}
