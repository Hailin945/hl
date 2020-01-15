package com.hl.student.service.student.controller;

import com.hl.school.api.service.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/27
 */
@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Resource
    private SchoolService schoolService;

    @GetMapping
    public String get() {
        return schoolService.get();
    }
}
