package com.qgStudio.controller;

import com.qgStudio.entity.User;
import com.qgStudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping
    public Result register(@RequestBody User user){
        System.out.println(user);
        return service.add(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/l")
    public Result login(@RequestBody User user, HttpServletResponse response){
        Result login = service.login(user);
        return login;
    }

    /**
     * 修改问题和答案
     * @param user
     * @return
     */
    @PostMapping("/q")
    public Result changeQuestion(@RequestBody User user, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return service.changeQuestion(user,token);
    }

    /**
     * 获取问题
     * @param request
     * @return
     */
    @PostMapping("/g")
    public Result getQuestion(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return service.getQuestion(token);
    }

    @PostMapping("/pg")
    public Result getQuestionByphone(HttpServletRequest request,@RequestBody User user){
        return service.getQuestionByPhone(user.getPhone());
    }

    /**
     * 修改密码，通过问题和答案
     * @param user
     * @return
     */
    @PostMapping("/c")
    public Result changePassword(@RequestBody User user, HttpServletRequest request){
        return service.changePassword(user);
    }

    /**
     * 绑定设备
     * @param user
     * @return
     */
    @PostMapping("/b")
    public Result bind(@RequestBody User user, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return service.bind(user,token);
    }

}
