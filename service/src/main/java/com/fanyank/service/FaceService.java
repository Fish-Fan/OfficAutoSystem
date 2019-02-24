package com.littlepig.service;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.littlepig.pojo.AttendanceResult;
import com.littlepig.pojo.GroupUser;
import com.littlepig.pojo.ScanResult;
import com.littlepig.pojo.User;
import com.littlepig.util.BaiduUtil;
import com.littlepig.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class FaceService {
    @Autowired
    private AttendanceService attendanceService;

    public String getScanResult(User current_user,String img) {
        String voice;
        String result = BaiduUtil.identify(img);
        Gson gson = new Gson();
        ScanResult scanResult = gson.fromJson(result,ScanResult.class);
        //处理返回的结果
        //结果示例
        //{"result":[{"uid":"fanyank","scores":[78.387321472168],"group_id":"developGroup","user_info":""}],"result_num":1,"log_id":3317459213032119}
        if(scanResult.getError_code() != null) {
            //分数过低
            voice = "未检测到人脸，请" + current_user.getUsername() + "重新拍照";
            return getJsonResult(current_user.getUsername(),voice,new Double("1"),"error");
        } else {
            GroupUser mostLikeUser = scanResult.getResult()[0];
            Double scores = mostLikeUser.getScores()[0];
            //如果大于80说明认证成功，执行签到逻辑
            if(scores >= 80) {
                System.out.println("mostLikeUserScores->" + mostLikeUser.getScores()[0]);

                if(mostLikeUser.getUid().equals(current_user.getId().toString())){
                    //匹配成功进行员工签到
                    attendanceService.executeUser(current_user);

                    voice = current_user.getUsername() + "签到成功" + current_user.getUsername() + "签到成功";
                    return getJsonResult(current_user.getUsername(),voice,scores,"success");

                }

            } else{
                //非用户本人
                voice = "认证失败，请" + current_user.getUsername() + "重新拍照";
                return getJsonResult(current_user.getUsername(),voice,scores,"warning");
            }
        }
        return null;

    }

    /**
     * 获取结果
     * @param username
     * @param voice
     * @param scores
     * @return
     */
    public String getJsonResult(String username,String voice,Double scores,String type) {
        try {
            AttendanceResult attendanceResult = new AttendanceResult();
            //语音合成，返回音频文件
            byte[] source = new byte[0];
            source = BaiduUtil.voiceCompose(voice);

            String key = QiniuUtil.uploadVoice(source);
            String keySource =  "http://cdn.fanyank.com/" + key;


            attendanceResult.setResult(type);
            attendanceResult.setVoice(keySource);
            attendanceResult.setScores(scores.toString());
            return JSON.toJSONString(attendanceResult);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
