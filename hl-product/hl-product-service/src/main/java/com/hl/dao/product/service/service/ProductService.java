package com.hl.dao.product.service.service;

import com.hl.dao.product.api.dataobject.ProductDO;

/**
 * @author Hailin
 * @date 2020/2/25
 */
public interface ProductService {

    boolean update(ProductDO productDO);

    ProductDO get(Long id);
}
