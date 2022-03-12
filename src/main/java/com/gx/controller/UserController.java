package com.gx.controller;

import com.gx.domain.User;
import com.gx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
 @Autowired
 private UserService userService;
 @RequestMapping("login")
 @ResponseBody
 public UserService login(int uname, int upwd, HttpSession httpsession){
  System.out.println("接受到了ajax的请求");
  User user1 = userService.login(uname,upwd);
  if(user1!=null){
   httpsession.setAttribute("user", user1);

  }
  return null;
 }

}
