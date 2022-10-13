package com.groomproject.sharedsidePJT.restaurants.service;

import com.groomproject.sharedsidePJT.baseUtil.Exception.BusinessException;
import com.groomproject.sharedsidePJT.baseUtil.Exception.ExMessage;
import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantRequest;
import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantResponse;
import com.groomproject.sharedsidePJT.restaurants.entity.Restaurant;
import com.groomproject.sharedsidePJT.restaurants.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse findById(Long id) {
        log.info("restaurant - findById: " + id);
        return restaurantRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("restaurant error - " + ExMessage.RESTAURANT_NONE_DATA.getMessage());
                    throw new BusinessException(ExMessage.RESTAURANT_NONE_DATA);
                }).toResponse();
    }

    @Override
    public void delete(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public RestaurantResponse save(RestaurantRequest request) {
        return restaurantRepository.save(request.toEntity()).toResponse();
    }

    @Override
    public List<RestaurantResponse> findAll() {
        return restaurantRepository.findAll()
                .stream().map(Restaurant::toResponse)
                .collect(Collectors.toList());
    }

}

