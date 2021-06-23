package cn.sharding.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.encrypt.algorithm.AESEncryptAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

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
    private AESEncryptAlgorithm aesEncryptAlgorithm;

    @RequestMapping("/getAesKey")
    public String getAesKey(){
        byte[] key = aesEncryptAlgorithm.getSecretKey();
        String base64Key = Base64.getEncoder().encodeToString(key);
        log.info("Real Aes Key is '{}' [Base64 Format]",base64Key);
        return base64Key;
    }

}
