package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
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

    /**
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId) throws Exception;


    /**
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}
