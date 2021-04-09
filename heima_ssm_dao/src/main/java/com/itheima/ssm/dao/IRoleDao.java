package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "roleDesc",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId ")),
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
