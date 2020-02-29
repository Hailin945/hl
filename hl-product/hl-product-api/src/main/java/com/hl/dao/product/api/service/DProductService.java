package com.hl.dao.product.api.service;

import com.hl.dao.product.api.dataobject.ProductDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author Hailin
 * @date 2020/2/25
 */
@FeignClient("hl-product-dao")
public interface DProductService {

    @PutMapping("/v1.0.0/product")
    boolean update(ProductDO productDO);

    @GetMapping("/v1.0.0/product")
    ProductDO get(Long id);
}
