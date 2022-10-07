package com.groomproject.sharedsidePJT.reservation.dto;

import com.groomproject.sharedsidePJT.reservation.entity.Reservation;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ReservationRequest {
    private Long restaurantId;
    // 유저정보를 body에 넣을지, jwt에 넣어서 파싱할지 선택해야함.
    //private Long memberId;

    // 인원
    private int people;

    // 예약 추가 요청 사항
    private String comment;

    // 예약 시간
    private LocalDateTime reservationTime;

    public Reservation toEntity() {
        return Reservation.builder()
                //.restaraunt(restrauntService.findById(this.restarurantId).toEntity())
                //.member(memberService.findById(this.memberId).toEntity())
                .comment(this.comment)
                .reservationTime(this.reservationTime)
                .people(this.people)
                .build();
    }
}
