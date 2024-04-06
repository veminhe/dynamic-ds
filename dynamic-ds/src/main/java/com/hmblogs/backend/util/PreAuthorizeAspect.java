package com.hmblogs.backend.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义权限实现
 *
 */
@Aspect
@Component
public class PreAuthorizeAspect{

    @Around("@annotation(com.hmblogs.backend.util.PreAuthorize)")
    public Object around(ProceedingJoinPoint point) throws Throwable
    {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        PreAuthorize annotation = method.getAnnotation(PreAuthorize.class);
        if (annotation == null)
        {
            return point.proceed();
        }

        if (!StringUtils.isEmpty(annotation.hasPermi()))
        {
            if (hasPermi(annotation.hasPermi()))
            {
                return point.proceed();
            }
            throw new PreAuthorizeException("没有权限");
        }

        return point.proceed();
    }

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(String permission) {
        // 这里模拟从数据库查出来了哪些用户有哪些权限。
        Map<String, String> userList = new HashMap<>();
        userList.put("system:stock:list", "admin,heming,abc");
        userList.put("system:product:list", "admin");
        String users = userList.get(permission);
        if (StringUtils.isEmpty(users)) {
            return false;
        }
        String[] userArray = users.split(",");
        String blogUser = RequestAttributeUtil.getCookie("blogUser");
        if (Arrays.asList(userArray).contains(blogUser)) {
            return true;
        }
        return false;
    }
}
