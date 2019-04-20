package com.fanyank.controller;

import com.alibaba.fastjson.JSON;
import com.fanyank.dto.FileTreeNodeDto;
import com.fanyank.dto.IMUserData;
import com.fanyank.pojo.Department;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.pojo.User;
import com.fanyank.service.FileSystemService;
import com.fanyank.service.IMService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IMController {
    @Autowired
    private IMService imService;



    @GetMapping(value = "/im/init",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getOwnMessage(HttpSession session) {
        IMUserData imUserData = new IMUserData();

        User currentUser = (User) session.getAttribute("current_user");
        User user = imService.getOwnMessage(currentUser.getId());
        List<Department> departmentList = imService.getMemberMessage(currentUser.getId());

        IMUserData.Data data = imUserData.getData();
        data.setMine(user);
        data.setFriend(departmentList);
        imUserData.setCode(0);
        return JSON.toJSONString(imUserData);
    }

    @GetMapping(value = "/im/member",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getMemberMessage(HttpSession session) {
        User currentUser = (User) session.getAttribute("current_user");
        List<Department> departmentList = imService.getMemberMessage(currentUser.getId());
        return JSON.toJSONString(departmentList);
    }



}
