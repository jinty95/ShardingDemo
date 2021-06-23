package cn.sharding.demo.controller;

import cn.sharding.demo.entity.User;
import cn.sharding.demo.entity.UserWithEnterprise;
import cn.sharding.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户Controller
 *
 * @author jinty
 * @date 2021/4/20
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(User user){
        if(user==null) user = new User();
        return userService.list(user);
    }

    @GetMapping("/listWithEnterprise")
    public List<UserWithEnterprise> listWithEnterprise(User user){
        if(user==null) user = new User();
        return userService.listWithEnterprise(user);
    }

}
