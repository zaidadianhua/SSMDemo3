package com.gx.controller;

import com.gx.dao.IAccountdao;
import com.gx.domain.Account;
import com.gx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account" ,method = RequestMethod.GET)
    public String findAll(Model model){  //存数据， Model对象
        System.out.println("Controller表现层：查询所有账户...");

        // 调用service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "account_list";
    }
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public String save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
//        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return "redirect:/account";
    }
    @RequestMapping(value = "/account/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        accountService.delete(id);
        return "redirect:/account";
    }
    @RequestMapping(value = "/account/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id,Model model){
        Account account = accountService.findById(id);
        model.addAttribute("accounts",account);
        return "account_update";
    }
    @RequestMapping(value = "/account", method=RequestMethod.PUT)
    public String updateEmployee(Account account){
        System.out.println(account.getMoney());
        accountService.updateAccount(account);
        return "redirect:/account";
    }
    @RequestMapping(value = "/account/queryBook",method = RequestMethod.POST)
    public String QueryBookByName(String name,Model model){
        System.out.println("querybookname"+name);
        List<Account> accountList = accountService.findByName(name);
        model.addAttribute("accountsname",accountList);
        System.out.println("来了git1");
        return "account_findByName";

    }
}

