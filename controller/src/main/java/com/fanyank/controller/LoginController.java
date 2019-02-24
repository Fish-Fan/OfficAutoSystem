package com.fanyank.controller;

import com.fanyank.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2018/3/13.
 */
@Controller
public class LoginController {
    @GetMapping("/user/login")
    public String gotoLogin(Model model) {
            model.addAttribute("user",  new User());
            return "gsy/login";
    }
    @GetMapping("personal_message")
    public String gotoPersonal(Model model,HttpSession session){
        User sessionUser = (User) session.getAttribute("current_user");
        model.addAttribute("user",sessionUser);
        return "gsy/personal_message";
    }

}
