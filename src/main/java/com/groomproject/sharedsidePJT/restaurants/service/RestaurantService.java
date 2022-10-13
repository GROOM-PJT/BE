package com.groomproject.sharedsidePJT.restaurants.service;

import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantRequest;
import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse findById(Long id);

    void delete(Long restaurantId);

    RestaurantResponse save(RestaurantRequest request);

    List<RestaurantResponse> findAll();


}
