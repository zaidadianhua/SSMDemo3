package com.gx.dao;

import com.gx.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Userdao {
    @Select("select * from user where uname=#{uname} and upwd=#{upwd}")
    public User login(@Param("uname") Integer uname,@Param("upwd") Integer upwd);


}
