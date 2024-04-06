package com.hmblogs.backend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;

    public String post(String url,Map map){
        // 设置请求头属性
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
        String results = restTemplate.postForObject(url, httpEntity, String.class);
        return results;
    }

    public String get(String url){
        // 设置请求头属性
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String results = restTemplate.getForObject(url, String.class);
        return results;
    }
}
