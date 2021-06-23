package cn.sharding.demo.service;

import cn.sharding.demo.dao.UserMapper;
import cn.sharding.demo.entity.User;
import cn.sharding.demo.entity.UserWithEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service
 *
 * @author jinty
 * @date 2021/4/20
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list(User user){
        return userMapper.list(user);
    }

    public List<UserWithEnterprise> listWithEnterprise(User user){
        return userMapper.listWithEnterprise(user);
    }

}
