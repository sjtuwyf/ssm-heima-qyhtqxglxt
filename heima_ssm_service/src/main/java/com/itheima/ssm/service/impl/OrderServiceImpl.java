package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
@Service
public class OrderServiceImpl implements IOrdersService {
    @Autowired
    IOrderDao orderDao;

    @Override
    public List<Orders> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll(page,size);
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }
}
