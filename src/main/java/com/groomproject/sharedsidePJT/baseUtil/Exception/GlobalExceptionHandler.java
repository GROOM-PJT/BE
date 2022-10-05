package com.groomproject.sharedsidePJT.baseUtil.Exception;

import com.groomproject.sharedsidePJT.baseUtil.response.dto.CommonResponse;
import com.groomproject.sharedsidePJT.baseUtil.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ResponseService responseService;
    @ExceptionHandler(BussinessException.class)
    protected CommonResponse golbalExceptionHandler(BussinessException e) {
        return responseService.failResult(e.getMessage());
    }
}
