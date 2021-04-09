package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
public interface IOrdersService {

    List<Orders> findAll(Integer page, Integer size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
