package cn.sharding.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    //企业用户ID
    private String euserId;

    //企业ID
    private String enterpriseId;

    //部门ID
    private String departmentId;

    //用户ID
    private String userId;

    //手机
    private String mobile;

    //用于存储手机的国际区号
    private String areaCode;

    //姓名
    private String name;

    //邮箱
    private String email;

    //地址
    private String address;

    //备注
    private String remark;

    //性别:0未知，1男，2女
    private Integer gender;

    //生日
    private Date birthday;

    //身份证
    private String identityCard;

    //民族
    private String nation;

    //政治面貌
    private String politics;

    //职位
    private String position;

    //员工号
    private String employeeNo;

    //创建者ID
    private String createUserId;

    //创建时间
    private Date createTime;

    //更新者ID
    private String modifyUserId;

    //更新时间
    private Date modifyTime;

}
