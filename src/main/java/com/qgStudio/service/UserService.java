package com.qgStudio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qgStudio.controller.Result;
import com.qgStudio.entity.User;

public interface UserService {
    Result add(User user);

    Result login(User user);

    Result changeQuestion(User user, String token);

    Result changePassword(User user);

    Result bind(User user,String token);

    Result getQuestion(String token);

    Result getQuestionByPhone(String phone);
}
