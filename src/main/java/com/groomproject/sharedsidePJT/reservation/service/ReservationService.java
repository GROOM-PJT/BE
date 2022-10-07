package com.groomproject.sharedsidePJT.reservation.service;

import com.groomproject.sharedsidePJT.reservation.dto.ReservationRequest;
import com.groomproject.sharedsidePJT.reservation.dto.ReservationResponse;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */
public interface ReservationService {
    ReservationResponse findById(Long id);

    void delete(Long reservationId);

    ReservationResponse save(ReservationRequest request);

    List<ReservationResponse> findAll();

    // List<ReservationResponse> findByMember(Long memberId);
    // List<ReservationResponse> findByRestaurant(Long restraurantId);
}
