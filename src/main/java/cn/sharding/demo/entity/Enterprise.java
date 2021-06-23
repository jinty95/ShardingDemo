package cn.sharding.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 企业
 *
 * @author jinty
 * @date 2021/6/23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {

    //企业ID
    private Long enterpriseId;

    //企业名称
    private String enterpriseName;

    //联系人
    private String contact;

    //联系人手机号码
    private String contactMobile;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
