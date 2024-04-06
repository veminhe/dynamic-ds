package com.hmblogs.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmblogs.backend.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> findBlogByPage(Blog blog, @Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    Integer findBlogCount(Blog blog);

    Integer updateBlogById(Blog blog);

    Integer addBlog(Blog blog);
}

