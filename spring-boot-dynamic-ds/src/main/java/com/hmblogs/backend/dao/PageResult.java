package com.hmblogs.backend.dao;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private long totalRecord;

    private List<T> list;
}
