package com.qgStudio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgStudio.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set question = #{user.question} , answer = #{user.answer} where id = #{id}")
    void changeQuestionAndAnswer(@Param("user") User user, @Param("id")Integer id);

    @Update("update user set password = #{password} where id = #{id}")
    void changePassword(@Param("password") String password, @Param("id") Integer id);

    @Update("update user set equipment = #{user.equipment} where id = #{id}")
    void bind(@Param("user") User user,@Param("id") Integer id);
}
