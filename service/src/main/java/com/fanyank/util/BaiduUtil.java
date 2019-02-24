package com.fanyank.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class BaiduUtil {
    public static byte[] voiceCompose(String username) throws UnsupportedEncodingException {
      final String APP_ID = "10973780";
      final String API_KEY = "R7AMChrrb0vjRc6h77nQ5m57";
      final String SECRET_KEY = "aG6sFmYtBdR6jAHGF7t9QA8DtNRwXbap";
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        TtsResponse res = client.synthesis(username, "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
//        if (data != null) {
//            try {
//                //后台播放
//                new Player(new ByteArrayInputStream(data)).play();
////                Util.writeBytesToFileSystem(data, "output.mp3");
//            } catch (JavaLayerException e) {
//                e.printStackTrace();
//            }
//        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
        return data;
    }


    /**
     * 图像识别验证主体
     * @param img
     * @return
     */
    public static String identify(String img) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/identify";
        try {
            //拿到图片流之后转换为字节码
            byte[] imgData = base64StrToByteArray(img);
            //进行base编码
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            //配置传给百度的参数
            Map<String,String> paramMap = new HashMap<>();

            //用户组ID
            paramMap.put("group_id","developGroup");
            //返回匹配分数个数
            paramMap.put("user_top_num","1");
            paramMap.put("face_top_num","1");

            //拼接参数
            String param = "group_id=" + paramMap.get("group_id") + "&user_top_num=" + paramMap.get("user_top_num") + "&face_top_num=" + paramMap.get("face_top_num") + "&images=" + imgParam;

            //注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = getAuth();

            //获得匹配结果
            String result = HttpUtil.post(url, accessToken, param);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * //对字节数组字符串进行Base64解码并生成图片
     * @param imgStr
     * @return
     */
    public static byte[] base64StrToByteArray(String imgStr) {
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            return b;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "tGRXZlf1mkakcLyvBQavtbGc";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "iRjhevwCvSXI1y6SEYyArWoXg5qYlvq4";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
