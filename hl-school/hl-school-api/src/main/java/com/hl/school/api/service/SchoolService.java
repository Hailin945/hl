package com.hl.school.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hailin
 * @date 2019/12/27
 */
@FeignClient(value = "hl-school-service")
public interface SchoolService {

    @GetMapping("/v1/school")
    String get();
}
