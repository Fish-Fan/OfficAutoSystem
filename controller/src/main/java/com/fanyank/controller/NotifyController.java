package com.littlepig.controller;

import com.alibaba.fastjson.JSON;
import com.littlepig.pojo.Notify;
import com.littlepig.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    @GetMapping(value = "/user/notify",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserNotify(Integer userId) {
        List<Notify> notifyList = notifyService.getNotifyListByUserId(userId);
        return JSON.toJSONString(notifyList);
    }

    @GetMapping("/user/notify/update")
    @ResponseBody
    public String updateNotify(Integer id) {
        notifyService.updateNotify(id);
        return "{\"status\":\"success\"}";
    }
}
