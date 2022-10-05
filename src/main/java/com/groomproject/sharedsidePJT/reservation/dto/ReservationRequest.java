package com.groomproject.sharedsidePJT.reservation.dto;

import com.groomproject.sharedsidePJT.reservation.entity.Reservation;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

@Data
@Builder
public class ReservationRequest {
    private Long restaurantId;

    // 예약 날짜
    private LocalDate date;
    // 예약 시간
    private Time time;
    // 예약 추가 요청 사항
    private String comment;

    // 인원
    private int adults;
    private int kids;

    // 예약 시간
    private LocalDateTime reservationAt;

    // 유저정보는 jwt에 넣어서 보내면 될 듯

    public Reservation toEntity() {
        return Reservation.builder()
                .date(this.date)
                .time(this.time)
                .comment(this.comment)
                .adults(this.adults)
                .kids(this.kids)
                .build();
    }
}
