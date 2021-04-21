package cn.jinty.sharding.controller;

import cn.jinty.sharding.entity.Encrypt;
import cn.jinty.sharding.service.EncryptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.encrypt.algorithm.AESEncryptAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

/**
 * Controller
 *
 * @author jinty
 * @date 2021/3/29
 **/
@Slf4j
@RestController
@RequestMapping("/encrypt")
public class EncryptController {

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private AESEncryptAlgorithm aesEncryptAlgorithm;

    @RequestMapping("/getAesKey")
    public String getAesKey(){
        byte[] key = aesEncryptAlgorithm.getSecretKey();
        String base64Key = Base64.getEncoder().encodeToString(key);
        log.info("Real Aes Key is '{}' [Base64 Format]",base64Key);
        return base64Key;
    }

    @RequestMapping("/insert")
    public String insert(@RequestBody Encrypt data){
        try{
            long begin = System.currentTimeMillis();
            encryptService.insert(data);
            long end = System.currentTimeMillis();
            log.info("保存记录耗时：used={}ms",end-begin);
        }catch (Exception e){
            log.error("保存记录异常！data="+data,e);
            return "保存失败";
        }
        return "保存成功";
    }

    @RequestMapping("/insertBatch")
    public String insertBatch(@RequestBody List<Encrypt> data){
        try{
            long begin = System.currentTimeMillis();
            encryptService.insertBatch(data);
            long end = System.currentTimeMillis();
            log.info("保存记录耗时：used={}ms",end-begin);
        }catch (Exception e){
            log.error("保存记录异常！data="+data,e);
            return "保存失败";
        }
        return "保存成功";
    }

    @RequestMapping("getById")
    public Encrypt getById(Integer id){
        try{
            Encrypt data = encryptService.getById(id);
            return data;
        }catch (Exception e){
            log.error("查询记录异常！id="+id,e);
            return null;
        }
    }

    @RequestMapping("list")
    public List<Encrypt> list(Encrypt data){
        try{
            long begin = System.currentTimeMillis();
            List<Encrypt> list = encryptService.list(data);
            long end = System.currentTimeMillis();
            log.info("查询记录耗时：used={}",end-begin);
            return list;
        }catch (Exception e){
            log.error("查询记录异常！data="+data,e);
            return null;
        }
    }

}
