package com.fanyank.controller;


import com.fanyank.pojo.GroupUser;
import com.fanyank.pojo.ScanResult;
import com.fanyank.pojo.User;
import com.fanyank.service.FaceService;
import com.fanyank.util.BaiduUtil;
import com.fanyank.util.QiniuUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


@Controller
public class FaceScanController {
    @Autowired
    private FaceService faceService;



    //签到功能
    @RequestMapping(value="/user/facesearch",method=RequestMethod.POST)
    @ResponseBody
    public String facesearch(String img, HttpSession session){
        User user = (User) session.getAttribute("current_user");
        return faceService.getScanResult(user,img);
    }




    @GetMapping("/user/ai/voice")
    @ResponseBody
    public String aiVoice() {
        try {
            byte[] source = BaiduUtil.voiceCompose("字符串");
            String key = QiniuUtil.uploadVoice(source);
            String keySource =  "http://cdn.fanyank.com/" + key;
            return "{\"voice\":\""+ keySource +"\"}";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value="/user/signin",method= RequestMethod.GET)
    public String signin(Model model){
        model.addAttribute("token",BaiduUtil.getAuth());
        return "basic/signin";
    }

    @PostMapping("/user/test")
    @ResponseBody
    public String faceTest(String img) {
        String result = BaiduUtil.identify(img);
        Gson gson = new Gson();
        ScanResult scanResult = gson.fromJson(result,ScanResult.class);
        //处理返回的结果
        //结果示例
        //{"result":[{"uid":"fanyank","scores":[78.387321472168],"group_id":"developGroup","user_info":""}],"result_num":1,"log_id":3317459213032119}
        GroupUser mostLikeUser = scanResult.getResult()[0];
        return gson.toJson(mostLikeUser);
    }


}
