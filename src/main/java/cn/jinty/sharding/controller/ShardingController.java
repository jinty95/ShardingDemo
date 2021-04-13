package cn.jinty.sharding.controller;

import cn.jinty.sharding.entity.Sharding;
import cn.jinty.sharding.service.ShardingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller
 *
 * @author jinty
 * @date 2021/3/18
 **/
@Slf4j
@RestController
@RequestMapping("/sharding")
public class ShardingController {

    @Autowired
    private ShardingService shardingService;

    @PostMapping("/insert")
    public String insert(@RequestBody Sharding data){
        try{
            shardingService.insert(data);
        }catch (Exception e){
            log.error("保存记录异常！data="+data,e);
            return "保存失败";
        }
        return "保存成功";
    }

    @GetMapping("/getById")
    public String getById(Long id){
        Sharding data = shardingService.selectById(id);
        if(data!=null){
            return data.toString();
        }
        return null;
    }

}
