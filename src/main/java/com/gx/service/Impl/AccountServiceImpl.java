package com.gx.service.Impl;

import com.gx.dao.IAccountdao;
import com.gx.domain.Account;
import com.gx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private IAccountdao iaccountdao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        return iaccountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service业务层：保存帐户...");
        iaccountdao.saveAccount(account);  //调用service中的saveAccount(account)方法
    }

    @Override
    public void delete(int id) {
        iaccountdao.deleteAccount(id);
    }

    @Override
    public Account findById(int id) {
        return iaccountdao.findById(id);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("进行了更新...");

        iaccountdao.updateAccount(account);

        System.out.println(account.getMoney());
    }

    @Override
    public List<Account> findByName(String name) {
        return iaccountdao.findByName(name);
    }

}

