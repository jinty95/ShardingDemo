package cn.sharding.demo.entity;

import lombok.*;

import java.util.Date;

/**
 * 用户 - 企业 - 聚合实体
 *
 * @author jinty
 * @date 2021/6/23
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserWithEnterprise extends User{

    //企业名称
    private String enterpriseName;

    //联系人
    private String contact;

    //联系人手机号码
    private String contactMobile;

}
