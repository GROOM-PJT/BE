package com.groomproject.sharedsidePJT.restaurants.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuDto {
    private String foodName;

    private int price;

}
