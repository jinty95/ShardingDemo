package cn.jinty.sharding.dao;

import cn.jinty.sharding.entity.User;
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

    @Select("<script>select * from tbl_user where 1=1 " +
            "<if test='data.mobile != null'> and mobile = #{data.mobile} </if>" +
            "order by create_time desc " +
            "<if test='data.pageStart != null and data.pageSize != null'>limit #{data.pageStart},#{data.pageSize} </if>" +
            "</script>")
    List<User> list(@Param("data")User user);

}
