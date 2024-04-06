package com.hmblogs.backend.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HardTest {
    public static void main(String[] args) {
        try {
// 创建URL对象
            URL url = new URL("http://iot-api.unisoft.cn/qtyVWasgeMqs/device/list/?sign=3f79882436861bf7126617cc90b82c2a&ts=1690508963");
// 打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// 设置请求方法
            conn.setRequestMethod("GET");
// 发送请求
            int responseCode = conn.getResponseCode();
// 读取响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
// 处理响应数据
            System.out.println(response.toString());
// 关闭连接
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//返回参数code == 200 就OK了


