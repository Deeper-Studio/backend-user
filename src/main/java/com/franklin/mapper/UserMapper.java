package com.franklin.mapper;


import com.franklin.pojo.User;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    public User queryUserByName(String name);





}
