package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/4
 */
public interface IProductService {


    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 产品添加
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;
}
