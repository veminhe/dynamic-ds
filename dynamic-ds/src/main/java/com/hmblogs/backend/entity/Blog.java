package com.hmblogs.backend.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_blog")
public class Blog {

    @TableId(value="blog_id", type = IdType.AUTO)
    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String createdBy;

    private Date createdDatetime;

    private String lastUpdatedBy;

    private Date lastUpdatedDatetime;
}

