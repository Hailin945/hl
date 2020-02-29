package com.hl.dao.product.service.controller;

import com.hl.dao.product.api.dataobject.ProductDO;
import com.hl.dao.product.service.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2020/2/25
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    // @Override
    @PutMapping
    public boolean update(ProductDO productDO) {
        return productService.update(productDO);
    }

    // @Override
    @GetMapping
    public ProductDO get(Long id) {
        return productService.get(id);
    }

    @GetMapping("/list")
    public String list() {
        return "success";
    }
}
