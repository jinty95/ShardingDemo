package cn.sharding.demo.entity;

import lombok.*;

import java.util.Date;

/**
 * 用户
 *
 * @author jinty
 * @date 2021/4/20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends PageParam {

    //用户ID
    private Long userId;

    //姓名
    private String name;

    //手机
    private String mobile;

    //手机的国际区号
    private String areaCode;

    //邮箱
    private String email;

    //地址
    private String address;

    //性别:0未知，1男，2女
    private Integer gender;

    //生日
    private Date birthday;

    //身份证
    private String idCard;

    //企业ID
    private Long enterpriseId;

    //创建时间
    private Date createTime;

    //更新时间
    private Date modifyTime;

}
