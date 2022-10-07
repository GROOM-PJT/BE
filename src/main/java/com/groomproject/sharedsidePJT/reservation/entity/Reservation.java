package com.groomproject.sharedsidePJT.reservation.entity;

import com.groomproject.sharedsidePJT.reservation.dto.ReservationResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 예약시 추가 요청사항
    private String comment;

    // 인원
    private int adults;
    private int kids;

    // 예약 날짜
    private LocalDate date;
    // 예약 시간
    private Time time;

    private LocalDateTime reservationAt;

    /**
     * @restaurant
     * @Relation: One To Many
     */

    /**
     * @reservationiTime
     * @Relation: One To One
     * @Comment: 식당 정보에서 가져와서 처리해야될 거 같은데, 어떻게 처리해야할지 의문
     */

    /**
     * @Member
     * @Relation: One To Many
     */

    /**
     * @paymentInfo
     * @Relation: One To One
     */

    public ReservationResponse toResponse() {
        return ReservationResponse.builder()
                .build();
    }
}
