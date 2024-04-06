package com.hmblogs.backend.dao;

import lombok.Data;

@Data
public class PageQuery<T> {
    private int pageNum;

    private int pageSize;

    private T criteria;
}
