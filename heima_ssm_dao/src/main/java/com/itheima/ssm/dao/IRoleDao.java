package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from role where id in(select roleId from user_role where userId=#{userId})")
    @Results({
            @Result(id=true,column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId")),
            //@Result(property = "roleName",column = "roleName")
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(id,roleName,roleDesc) values(uuid_short(),#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;
}
