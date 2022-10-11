package com.groomproject.sharedsidePJT.restaurants.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.groomproject.sharedsidePJT.restaurants.entity.Restaurant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RestaurantResponse {
    // 식당 정보
    private Restaurant restaurant;

    //시작 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime openTime;

    //종료 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime closeTime;

    //예약 가능 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime availableTime;

    // 이름
    private String name;

    // 설명
    private String description;

    // 테마
    private String theme;
}
