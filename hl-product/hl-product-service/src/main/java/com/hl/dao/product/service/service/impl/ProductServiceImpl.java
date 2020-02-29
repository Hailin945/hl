package com.hl.dao.product.service.service.impl;

import com.hl.dao.product.api.dataobject.ProductDO;
import com.hl.dao.product.service.mapper.ProductMapper;
import com.hl.dao.product.service.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2020/2/25
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean update(ProductDO productDO) {
        Integer result = productMapper.update(productDO);
        return result >= 1;
    }

    @Override
    public ProductDO get(Long id) {
        return productMapper.get(id);
    }
}
