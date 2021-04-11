package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
public interface IUserService extends UserDetailsService {
    /**
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;

    /**
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
