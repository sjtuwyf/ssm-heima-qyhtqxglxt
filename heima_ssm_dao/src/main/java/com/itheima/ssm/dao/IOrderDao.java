package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
public interface IOrderDao {

    /**
     * 查询所有订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderNum",column = "orderStatus"),
            @Result(property = "orderNum",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "peopleDesc"),
            @Result(property = "product",column = "productId" ,javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),

    })
    public List<Orders> findAll(Integer page , Integer size) throws Exception;

    /**
     * 通过id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderName"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType =Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "travellerId",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(String id);
}
