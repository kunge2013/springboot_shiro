package com.basic.core.login;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/article")
public class CmsController {
    /**
     * 查询文章列表
     */
    @RequiresPermissions("article:list")
    @GetMapping("/listArticle")
    public Object listArticle(HttpServletRequest request) {
        return "查詢成功!!!!";
    }

}
