package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/4
 */

public interface IProductDao {

    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 产品添加
     * @param product
     * @throws Exception
     */
    @Insert("insert into " +
            "product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values" +
            "(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}
