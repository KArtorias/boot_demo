package com.by.repository.mapper;

import com.by.repository.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //增加用户
    int addUser(User user);
    //删除用户
    int deleteUserById(Long id);
    //修改用户
    int updateByPrimaryKey(User record);
    //查询用户
    User getUserById(Long id);
    User getUserByName(String name);
    //查询用户列表
    List<User> listUser(Integer pageNum, Integer pageSize);
}
