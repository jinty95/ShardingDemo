package cn.sharding.demo.service;

import cn.sharding.demo.dao.EncryptMapper;
import cn.sharding.demo.entity.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 *
 * @author jinty
 * @date 2021/3/29
 **/
@Service
public class EncryptService {

    @Autowired
    private EncryptMapper encryptMapper;

    public void insert(Encrypt data){
        encryptMapper.insert(data);
    }

    public void insertBatch(List<Encrypt> data){
        encryptMapper.insertBatch(data);
    }

    public Encrypt getById(Integer id){
        return encryptMapper.getById(id);
    }

    public List<Encrypt> list(Encrypt data){
        return encryptMapper.list(data);
    }

}
