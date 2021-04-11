package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/11
 */
public interface ISysLogService {

    /**
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;


}
