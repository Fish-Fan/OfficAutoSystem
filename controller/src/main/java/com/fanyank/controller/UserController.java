package com.fanyank.controller;

import com.fanyank.dto.UserResult;
import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import com.fanyank.util.QiniuUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.validation.Valid;

/**
 * Created by lenovo on 2018/3/13.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String userLogin(Model model, @Valid User user, HttpServletRequest  req){
        HttpSession session = req.getSession();
        User realuser =userService.selectUserByUsername(user.getUsername());
            System.out.println("userController->" + realuser.getPosition() + realuser.getDepartment());
        if (realuser!=null) {
            String password = user.getPassword();
            String selectPassword  = realuser.getPassword();
            if(password.equals(selectPassword)){/*
                        model.addAttribute("msg", "登录成功!");*/
                userService.updateSignByUsername(realuser.getUsername());
                session.setAttribute("current_user",realuser);
                model.addAttribute("user",realuser);
                return "gsy/personal_message";
                //登录成功
            }else{
                //登录失败
                model.addAttribute("mistake", "密码错误！");
                return "gsy/login";
            }
        }else {
            model.addAttribute("mistake", "用户不存在！");
            return "gsy/login";
        }
    }
    //用户退出销毁session 跳转到登录页
    @RequestMapping("/user/userExit")
    public String userExit(User user,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_user");
        userService.exitSignByUsername(sessionUser.getUsername());
        session.invalidate();
        return "gsy/login";
    }
    @RequestMapping(value="/user/insertUser", method =RequestMethod.GET)
    public String gotoInsert(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "gsy/register";
    }

    @RequestMapping(value="/user/insertUser", method = RequestMethod.POST)
    public String insertUser(Model model, User user) {
        int r = userService.insertUser(user);
        model.addAttribute("user",user);
        return "gsy/login";
    }

    @RequestMapping(value="/user/forgetPassword",method = RequestMethod.GET)
    public String forgettPassword(Model model,User user){
        model.addAttribute("user",user);
        return "gsy/forget_password";
    }

    @RequestMapping(value = "/user/forgetPassword",method = RequestMethod.POST)
    public String forgetPassword(Model model,User user ,HttpServletRequest  req){
        HttpSession session = req.getSession();
        User em = userService.selectUserByEmail(user.getEmail());
        if (em!=null){
            session.setAttribute("current_email",em);
            user.setPassword(null);
            model.addAttribute("user",user);
            return "gsy/update_password";//验证成功
        }
        else{
            model.addAttribute("mistake","邮箱输入错误！");
            return "gsy/forget_password";
        }
    }

    @RequestMapping(value="/user/updatePasswords",method = RequestMethod.GET)//个人信息内修改密码跳转
    public String updatePasswordss(Model model,User user,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_user");
        user =  userService.selectMessageByUsername(sessionUser.getUsername());
        System.out.println(user);
        user.setPassword(null);
        model.addAttribute("user",user);
        return "gsy/update_passwords";
    }

    @RequestMapping(value = "/user/updatePasswords",method = RequestMethod.POST)//个人信息内修改密码
    public String updatePasswords(Model model,User user,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_user");
        User user0 = userService.selectUserByUsername(sessionUser.getUsername());
        String pwd = user.getPassword();
        if (pwd == null || pwd == ""){
            model.addAttribute("mistake","密码格式有误！请重新输入！");
            return "gsy/update_passwords";
        }else {
            user0.setPassword(user.getPassword());
            int us = userService.updatePasswordByUsername(user0);
            System.out.println(user0);
            userService.exitSignByUsername(user0.getUsername());
            session.invalidate();
            user.setUsername(null);
            user.setPassword(null);
            model.addAttribute("user",user);
            return "gsy/login";
        }
    }

    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST)//验证完邮箱忘记密码的修改
    public String updatePassword(Model model,User user,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_email");
        User user1 = userService.selectUserByEmail(sessionUser.getEmail());
        String pwd = user.getPassword();
        if (pwd == null || pwd == ""){
            model.addAttribute("mistake","密码格式有误！请重新输入！");
            return "gsy/update_password";
        }else {
            user1.setPassword(user.getPassword());
            int us = userService.updatePasswordByEmail(user1);
            System.out.println(user1);
            user.setPassword(null);
            model.addAttribute("user",user);
            return "gsy/login";
        }
    }

    @RequestMapping(value="/message",method = RequestMethod.GET)
    public String message(Model model,User user,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_user");
        user =   userService.selectMessageByUsername(sessionUser.getUsername());
        System.out.println(user);
        model.addAttribute("user",user);
        model.addAttribute("token", QiniuUtil.getToken());
        return "gsy/message";
}
    @RequestMapping(value="/updateMessage",method = RequestMethod.POST)
    public String updateMessage(Model model,User user,HttpSession session, HttpServletRequest  req){
        User sessionUser = (User) session.getAttribute("current_user");
        user.setUsername(sessionUser.getUsername());
        user.setPosition(sessionUser.getPosition());
        user.setDepartment(sessionUser.getDepartment());
        user.setAvatar(sessionUser.getAvatar());
        userService.updateMessageByUsername(user);
        System.out.println(user);
        HttpSession session1 = req.getSession();
        User newuser = userService.selectUserByUsername(user.getUsername());
        session1.setAttribute("new_user",newuser);
        model.addAttribute("user",newuser);
        return "gsy/personal_message";
    }

    @PostMapping("/updateAvatar")
    @ResponseBody
    public void updateAvatar(String key,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        user.setAvatar(key);
        userService.updateMessageByUsername(user);
    }

    /**
     * 根据idlike查找用户
     * @param id
     * @return
     */
    @GetMapping(value = "/user/search/byid",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String searchById(Integer id) {
        List<User> userList = userService.findByLikeId(id);
        System.out.println(userList);
        UserResult userResult = new UserResult(userList.size(),userList);
        Gson gson = new Gson();
        return gson.toJson(userResult);
        //fastjson坑，解析两个相同对象时，会变成引用类型导致解析失败
//        return JSON.toJSONString(userResult);
    }
}
