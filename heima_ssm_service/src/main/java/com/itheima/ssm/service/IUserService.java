package com.itheima.ssm.service;

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
}
