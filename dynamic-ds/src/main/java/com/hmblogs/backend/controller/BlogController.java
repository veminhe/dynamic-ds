package com.hmblogs.backend.controller;

import com.hmblogs.backend.dao.PageQuery;
import com.hmblogs.backend.dao.PageResult;
import com.hmblogs.backend.entity.Blog;
import com.hmblogs.backend.service.BlogServiceImpl;
import com.hmblogs.backend.util.BlogConstant;
import com.hmblogs.backend.util.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @PostMapping("findBlogByPage")
    public BlogResponse findBlogByPage(@RequestBody Blog blog,
                                           @Param("pageNum") Integer pageNum,
                                           @Param("pageSize") Integer pageSize,
                                       @Param(value = "dsKey") String dsKey){
        PageQuery<Blog> blogPage = new PageQuery<Blog>();
        blogPage.setCriteria(blog);
        blogPage.setPageNum(pageNum);
        blogPage.setPageSize(pageSize);
        DynamicDataSource.dataSourceName.set(dsKey);
        PageResult<Blog> result =  blogServiceImpl.findBlogByPage(blogPage);
        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setCode(BlogConstant.SUCCESS_CODE);
        blogResponse.setResult(result);
        return blogResponse;
    }

    @PostMapping("updateBlogById")
    public BlogResponse updateBlogById(@RequestBody Blog blog){
        Integer result =  blogServiceImpl.updateBlogById(blog);
        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setCode(BlogConstant.SUCCESS_CODE);
        blogResponse.setResult(result);
        return blogResponse;
    }

    @PostMapping("addBlog")
    public BlogResponse addBlog(@RequestBody Blog blog,
                                @Param(value = "dsKey") String dsKey){
        DynamicDataSource.dataSourceName.set(dsKey);
        Integer result =  blogServiceImpl.addBlog(blog);
        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setCode(BlogConstant.SUCCESS_CODE);
        blogResponse.setResult(result);
        return blogResponse;
    }
}
