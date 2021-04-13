package cn.jinty.sharding.service;

import cn.jinty.sharding.dao.ShardingMapper;
import cn.jinty.sharding.entity.Sharding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service
 *
 * @author jinty
 * @date 2021/3/18
 **/
@Service
public class ShardingService {

    @Autowired
    private ShardingMapper shardingMapper;

    public void insert(Sharding data){
        if(data.getId()==null){
            shardingMapper.insertWithNoId(data);
        }else{
            shardingMapper.insert(data);
        }
    }

    public Sharding selectById(Long id){
        return shardingMapper.selectById(id);
    }

}
