package com.fanyank.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class QiniuUtil {
    public static String getToken() {
        Auth auth = Auth.create(ConfigProp.getProperty("qiniu.ak"),ConfigProp.getProperty("qiniu.sk"));
        StringMap map = new StringMap();
        map.put("returnBody","{\"success\":\"true\",\"file_path\":\"http://cdn.fanyank.com/${key}\"}");
        return auth.uploadToken(ConfigProp.getProperty("qiniu.bucket"),null,3600,map);
    }

    public static String uploadVoice(byte[] source) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone1());
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        byte[] uploadBytes = source;
        Auth auth = Auth.create(ConfigProp.getProperty("qiniu.ak"),ConfigProp.getProperty("qiniu.sk"));
        String upToken = auth.uploadToken(ConfigProp.getProperty("qiniu.bucket"));

        try {
            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }
}
