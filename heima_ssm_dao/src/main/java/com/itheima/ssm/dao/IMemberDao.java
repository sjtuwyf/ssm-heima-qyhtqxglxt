package com.itheima.ssm.dao;


import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @Author ssqswyf
 * @Date 2021/4/7
 */
public interface IMemberDao {

    /**
     * 根据id查询成员
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
