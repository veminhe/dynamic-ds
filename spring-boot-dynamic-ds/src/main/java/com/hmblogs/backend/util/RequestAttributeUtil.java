package com.hmblogs.backend.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class RequestAttributeUtil {
    public static String getCookie(String str){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        // 遍历所有的Cookie并打印名称和值
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if(str.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        } else {
            return "No cookies found.";
        }

        return "";
    }
}
