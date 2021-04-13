package cn.jinty.sharding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加密
 *
 * @author jinty
 * @date 2021/3/29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Encrypt extends PageParam{

    //主键
    private Integer id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //手机号码
    private String phone;

    //身份证号码
    private String idcard;

    //图片
    private String img;

    //学历：1小学，2初中，3高中，4本科，5研究生
    private Integer education;

    //就职企业
    private String enterprise;

    //身高(cm)
    private Integer height;

    //体重(kg)
    private Integer weight;

    //民族：1汉族，2少数民族
    private Integer nation;

    //国家：1中国，2外国
    private Integer country;

    //是否已删除：0否，1是
    private Integer isDel;

}
