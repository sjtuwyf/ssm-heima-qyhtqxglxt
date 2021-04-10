package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/9
 */
public interface IPermissionDao {

    /**
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in " +
            "(select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    /**
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(id,permissionName,url) values(uuid_short(),#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
