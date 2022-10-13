package com.groomproject.sharedsidePJT.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

@Data
@Builder
public class ReservationResponse {
    // 식당 정보
    // private Restaurant restaurant;

    // 예약 번호
    private Long id;

    // 예약 날짜
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime reservationTime;

    // 예약 추가 요청 사항
    private String comment;

    // 인원
    private int people;

    // 예약 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createAt;
}
