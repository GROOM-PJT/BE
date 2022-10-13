package com.groomproject.sharedsidePJT.restaurants.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.groomproject.sharedsidePJT.restaurants.entity.Restaurant;
import com.groomproject.sharedsidePJT.restaurants.entity.menu;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RestaurantRequest {
    // 이름
    private String name;
    // 테마
    private String theme;
    // 예약 가능 시간
    private LocalDateTime availableTime;
    // 섦명
    private String description;
    // 시작 시간
    private LocalDateTime openTime;
    // 종료 시간
    private LocalDateTime closeTime;
    //메뉴
    private List<menu> menu;



    public Restaurant toEntity() {
        return Restaurant.builder()
                .name(this.name)
                .availableTime(this.availableTime)
                .theme(this.theme)
                .openTime(this.openTime)
                .closeTime(this.closeTime)
                .description(this.description)
                .build();
    }
}
