package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/10
 */
public interface IPermissionService {

    /**
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

    /**
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;
}
