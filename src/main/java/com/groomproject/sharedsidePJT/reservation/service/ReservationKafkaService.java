package com.groomproject.sharedsidePJT.reservation.service;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.groomproject.sharedsidePJT.reservation.dto.ReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/11
 */

@Slf4j
@Service
@KafkaListener(
        topics = "${topic.reservation.name}",
        groupId = "${spring.kafka.consumer.group-id}",
        containerFactory = "kafkaListenerContainerFactory"
)
@RequiredArgsConstructor
public class ReservationKafkaService {

    private final ReservationServiceImpl reservationService;

//    @KafkaHandler
//    public void listData(@Payload List<ReservationRequest> reservations) {
//        for(ReservationRequest reservation : reservations) {
//            reservationService.save(reservation);
//            log.info("Consumed Message List: " + reservation.toString());
//        }
//    }

    @KafkaHandler
    public void singleData(@Payload ReservationRequest reservation) {
//        log.info("Consumed Header : " + headers.toString());
        reservationService.save(reservation);
        log.info("Consumed Message Single: " + reservation.toString());
    }

    // ReservationRequest가 아닌 다른 object데이터가 존재하는 경우, 무시
    @KafkaHandler(isDefault = true)
    public void ignore(ConsumerRecord<?, ?> record) {
        log.info("ignore");
        log.info("reservation kafka service (ignore data): " + record.toString());
        //log.info("reservation kafka service (ignore data): " + jsonSerializable.toString());
    }
}
