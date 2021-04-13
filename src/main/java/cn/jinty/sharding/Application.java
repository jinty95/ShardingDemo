package cn.jinty.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.encrypt.algorithm.AESEncryptAlgorithm;
import org.apache.shardingsphere.replicaquery.api.config.ReplicaQueryRuleConfiguration;
import org.apache.shardingsphere.replicaquery.spi.ReplicaLoadBalanceAlgorithm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author jinty
 * @date 2021/3/17
 **/
@Slf4j
@MapperScan(basePackages = "cn.jinty.sharding.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
