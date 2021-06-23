package cn.sharding.demo.dao;

import cn.sharding.demo.entity.User;
import cn.sharding.demo.entity.UserWithEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO
 *
 * @author jinty
 * @date 2021/4/20
 **/
@Mapper
@Repository
public interface UserMapper {

    @Select("<script>" +
            "select * from tbl_user " +
            "where 1=1 " +
            "<if test='data.mobile != null'> and mobile = #{data.mobile} </if>" +
            "order by create_time desc " +
            "<if test='data.pageStart != null and data.pageSize != null'>limit #{data.pageStart},#{data.pageSize} </if>" +
            "</script>")
    List<User> list(@Param("data")User user);

    //虽然t1和t2都有加密字段，但是只有t1在sql解析后做了密文列转换，t2保持原逻辑列，但是对于结果集却是t1和t2的加密字段都做解密
    //所以会出现t2查出明文信息，却对其做解密操作，然后报base64格式错误或者密文格式错误的异常
    @Select("<script>" +
            "select t1.*, t2.enterprise_name, t2.contact, t2.contact_mobile from tbl_user t1 left join tbl_enterprise t2 on t1.enterprise_id = t2.enterprise_id " +
            "where 1=1 " +
            "<if test='data.mobile != null'> and t1.mobile = #{data.mobile} </if>" +
            "order by t1.create_time desc " +
            "<if test='data.pageStart != null and data.pageSize != null'>limit #{data.pageStart},#{data.pageSize} </if>" +
            "</script>")
    List<UserWithEnterprise> listWithEnterprise(@Param("data")User user);

}
