package cn.jinty.sharding.service;

import cn.jinty.sharding.dao.UserMapper;
import cn.jinty.sharding.entity.User;
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

}
