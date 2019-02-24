package com.fanyank.service;


import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public interface FaceService {

    public String getScanResult(User current_user, String img);

    /**
     * 获取结果
     * @param username
     * @param voice
     * @param scores
     * @return
     */
    public String getJsonResult(String username,String voice,Double scores,String type);
}
