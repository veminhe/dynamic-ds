package com.hmblogs.backend.service;

import com.hmblogs.backend.dao.BlogMapper;
import com.hmblogs.backend.dao.PageQuery;
import com.hmblogs.backend.dao.PageResult;
import com.hmblogs.backend.entity.Blog;
import com.hmblogs.backend.util.RequestAttributeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogServiceImpl {

    @Autowired
    private BlogMapper blogMapper;

    public PageResult<Blog> findBlogByPage(PageQuery<Blog> blogPage){
        PageResult<Blog> result = new PageResult<>();
        Blog blog = blogPage.getCriteria();
        Integer count = blogMapper.findBlogCount(blog);
        result.setTotalRecord(count);
        Integer begin = (blogPage.getPageNum()-1)*blogPage.getPageSize();
        List<Blog> list = blogMapper.findBlogByPage(blog,begin,blogPage.getPageSize());
        result.setList(list);
        return result;
    }

    public Integer updateBlogById(Blog blog){
        return blogMapper.updateBlogById(blog);
    }

    public Integer addBlog(Blog blog){
        String userName = RequestAttributeUtil.getCookie("userName");
        blog.setCreatedBy(userName);
        blog.setLastUpdatedBy(userName);
        return blogMapper.addBlog(blog);
    }
}
