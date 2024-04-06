package com.hmblogs.backend.util;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

public class CalculateUtil {

    @Test
    public void main(){
        String expression2 = "score=A*B*C";
        JSONObject parseObject = new JSONObject();
        parseObject.put("A", 3);
        parseObject.put("B", 3);
        parseObject.put("C", 1);
        Object execute2 = AviatorEvaluator.execute(expression2, parseObject);
        System.out.println("结果为："+execute2);
    }
}
