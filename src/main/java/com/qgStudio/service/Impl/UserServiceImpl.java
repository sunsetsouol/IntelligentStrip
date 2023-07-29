package com.qgStudio.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgStudio.controller.Result;
import com.qgStudio.entity.User;
import com.qgStudio.mapper.UserMapper;
import com.qgStudio.service.UserService;
import com.qgStudio.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public Result add(User user) {
        try {
            user.setName(user.getPhone());
            user.setEquipment("1");
            userMapper.insert(user);
        } catch (Exception e) {
            return Result.error("该手机号已被注册");
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getPhone,user.getPhone());
        Integer id = userMapper.selectOne(lambdaQueryWrapper).getId();
        Map<String ,Object> claims = new HashMap<>();
        claims.put("id",id);
        String s = JwtUtil.generateJwt(claims);
        return Result.success(s,"注册成功");
    }

    @Override
    public Result login(User user) {
        if (user == null || user.getPhone() == null || user.getPassword() == null){
            return Result.error("手机号密码不能为空");
        }
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getPhone,user.getPhone()).eq(User::getPassword,user.getPassword());
        User select = userMapper.selectOne(userLambdaQueryWrapper);
        if (select != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", select.getId());
            return Result.success(JwtUtil.generateJwt(claims),"登陆成功");
        }
        return Result.error("账号或密码错误");
    }

    @Override
    public Result changeQuestion(User user, String token) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            return Result.error("登录信息不正确");
        }
        Integer id = (Integer) claims.get("id");
        userMapper.changeQuestionAndAnswer(user,id);
        return Result.success("修改成功");
    }

    @Override
    public Result changePassword(User user) {
        String phone = user.getPhone();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getPhone,phone);
        User selectOne = userMapper.selectOne(queryWrapper);
        if (selectOne.getAnswer().equals(user.getAnswer())){
            userMapper.changePassword(user.getPassword(),selectOne.getId());
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @Override
    public Result bind(User user, String token) {
        Claims claims = JwtUtil.parseJWT(token);
        Integer id = (Integer) claims.get("id");
        userMapper.bind(user,id);
        return  Result.success("绑定成功");
    }

    @Override
    public Result getQuestion(String token) {
        Claims claims = JwtUtil.parseJWT(token);
        Integer id = (Integer) claims.get("id");
        User select = userMapper.selectById(id);
        return Result.success(select.getQuestion());
    }

    @Override
    public Result getQuestionByPhone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getPhone,phone);
        User selectOne = userMapper.selectOne(queryWrapper);
        return Result.error(selectOne.getQuestion());
    }


}
