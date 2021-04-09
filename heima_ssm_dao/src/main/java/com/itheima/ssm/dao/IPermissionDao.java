package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/9
 */
public interface IPermissionDao {

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in " +
            "(select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;
}
