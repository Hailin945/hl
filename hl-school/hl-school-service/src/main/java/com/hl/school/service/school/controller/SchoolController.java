package com.hl.school.service.school.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Hailin
 * @date 2019/12/27
 */
@RestController
@RequestMapping("/v1/school")
public class SchoolController {

    @PostMapping
    public String save() {
        return "save success";
    }

    @DeleteMapping
    public String delete() {
        return "delete success";
    }

    @GetMapping
    public String get() {
        return "get success";
    }
}
