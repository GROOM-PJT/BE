package com.groomproject.sharedsidePJT.reservation.entity;

import com.groomproject.sharedsidePJT.reservation.dto.ReservationResponse;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
@AllArgsConstructor
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 예약 번호

    // 예약시 추가 요청사항
    private String comment;

    // 인원
    private int people;

    // 예약 날짜
    private LocalDateTime reservationTime;

    // 예약 시간
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * @ManyToOne(fetch = FetchType.LAZY)
     * private Restaurant restraurant;
     *
     * @ManyToOne(fetch = FetchType.LAZY)
     * private Member member;
     */


    /**
     * @OneToOne
     * private PaymentInfo paymentInfo;
     */

    public ReservationResponse toResponse() {
        return ReservationResponse.builder()
                .id(this.id)
                .comment(this.comment)
                .reservationTime(this.reservationTime)
                .people(this.people)
                .createAt(this.createdAt)
                .build();
    }
}
