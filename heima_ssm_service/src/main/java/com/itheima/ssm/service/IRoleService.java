package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/10
 */
public interface IRoleService {

    /**
     * @return
     * @throws Exception
     */
    public List<Role> findAll() throws Exception;

    /**
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;
}
