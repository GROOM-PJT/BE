package com.groomproject.sharedsidePJT.restaurants.controller;

import com.groomproject.sharedsidePJT.baseUtil.response.dto.CommonResponse;
import com.groomproject.sharedsidePJT.baseUtil.response.dto.ListResponse;
import com.groomproject.sharedsidePJT.baseUtil.response.dto.SingleResponse;
import com.groomproject.sharedsidePJT.baseUtil.response.service.ResponseService;
import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantRequest;
import com.groomproject.sharedsidePJT.restaurants.dto.RestaurantResponse;
import com.groomproject.sharedsidePJT.restaurants.service.RestaurantServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "식당")
@RequestMapping("api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;
    private final ResponseService responseService;

    @ApiOperation(value = "식당 정보 추가", notes = "식당 정보를 추가")
    @PostMapping("/post")
    public CommonResponse addRestaurant(HttpServletRequest request,
                                        @RequestBody RestaurantRequest restaurant) {
        log.info("test info");
        restaurantService.save(restaurant);
        return responseService.successResult();
    }

    @ApiOperation(value = "상세 정보", notes = "상세 정보를 조회")
    @GetMapping("/detail/{restaurantId}")
    public SingleResponse<RestaurantResponse> findById(HttpServletRequest request,
                                                       @PathVariable Long restaurantId) {
        return responseService.singleResult(restaurantService.findById(restaurantId));
    }


    @ApiOperation(value = "상세 정보", notes = "상세 정보를 조회")
    @GetMapping("/all")
    public ListResponse<RestaurantResponse> findById(HttpServletRequest request) {
        return responseService.ListResult(restaurantService.findAll());
    }

    @ApiOperation(value = "삭제", notes = "삭제한다.")
    @DeleteMapping("/delete/{restaurantId}")
    public CommonResponse delete(HttpServletRequest request,
                                 @PathVariable Long restaurantId) {
        restaurantService.delete(restaurantId);
        return responseService.successResult();
    }
}
