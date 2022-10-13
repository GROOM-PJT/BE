package com.groomproject.sharedsidePJT.restaurants.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

}
