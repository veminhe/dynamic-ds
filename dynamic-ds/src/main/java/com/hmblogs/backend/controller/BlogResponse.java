package com.hmblogs.backend.controller;

import lombok.Data;

@Data
public class BlogResponse {
    private String code;//请求结果编码
    private String reason;//失败的原因
    private Object result;//请求成功得到的结果
}
