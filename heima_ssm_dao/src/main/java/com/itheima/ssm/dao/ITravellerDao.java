package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
public interface ITravellerDao {


    /**
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where ordersId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
