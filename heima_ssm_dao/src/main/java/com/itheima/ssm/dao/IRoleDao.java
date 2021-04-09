package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/9
 */
public interface IRoleDao {


    /**
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from user_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
