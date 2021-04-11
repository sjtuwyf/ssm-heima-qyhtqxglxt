package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/11
 */
public interface ISysLogDao {

    /**
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) " +
            "values(uuid_short(),#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    @Select("select * from sysLog")
    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;
}
