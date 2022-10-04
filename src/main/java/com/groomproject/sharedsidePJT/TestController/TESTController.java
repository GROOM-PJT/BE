package com.groomproject.sharedsidePJT.TestController;

import com.groomproject.sharedsidePJT.baseUtil.response.dto.SingleResponse;
import com.groomproject.sharedsidePJT.baseUtil.response.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/04
 */

@Api(tags = "00. TEST")
@RequestMapping(value = "/api/v1/test")
@RestController
@RequiredArgsConstructor
public class TESTController {
    private final ResponseService responseService;
    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "hello api example")
    public SingleResponse<String> hello() {
        return responseService.singleResult("Hello");
    }
}