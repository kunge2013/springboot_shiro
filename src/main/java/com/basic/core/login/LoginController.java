package com.basic.core.login;

import com.alibaba.fastjson.JSONObject;
import com.basic.core.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private ILoginService loginService;

    /**
     * 登录
     */
    @PostMapping("/auth/{userName}/{passWord}")
    public Object authLogin(@PathVariable("userName") String userName,@PathVariable("passWord") String passWord) {
        return loginService.authLogin(userName,passWord);
    }

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public Object getInfo() {
        return loginService.getInfo();
    }

//    /**
//     * 登出
//     */
//    @PostMapping("/logout")
//    public JSONObject logout() {
//        return loginService.logout();
//    }
}
