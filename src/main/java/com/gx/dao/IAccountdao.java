package com.gx.dao;

import com.gx.domain.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //此注解代表这是一个持久层，用法类似@controller、@service
public interface IAccountdao {
    @Select("select * from account")
    public List<Account> findAll();
    @Insert("insert into account (id,name,money,gender) value(#{id},#{name},#{money},#{gender})")
    public void saveAccount(Account account);
    @Delete("delete from account where id=#{id}")
    public void deleteAccount(@Param("id") Integer id);
    @Select("select * from account where id=#{id}")
    public Account findById(@Param("id") Integer id);
    @Update("update account set name=#{name},money=#{money},gender=#{gender} where id=#{id}")
    public void updateAccount(Account account);
    @Select("select * from account where name=#{name}")
    public List<Account> findByName(@Param("name") String name);
}

