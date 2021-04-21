package cn.sharding.demo.dao;

import cn.sharding.demo.entity.Encrypt;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO
 *
 * @author jinty
 * @date 2021/3/29
 **/
@Mapper
@Repository
public interface EncryptMapper {

    @Insert("insert into tbl_encrypt(`name`,`age`,`phone`,`idcard`,`img`,`education`,`enterprise`,`height`,`weight`,`nation`,`country`) " +
            "values(#{data.name},#{data.age},#{data.phone},#{data.idcard},#{data.img},#{data.education},#{data.enterprise},#{data.height},#{data.weight},#{data.nation},#{data.country});")
    void insert(@Param("data")Encrypt data);

    @Insert("<script>insert into tbl_encrypt(`name`,`age`,`phone`,`idcard`,`img`,`education`,`enterprise`,`height`,`weight`,`nation`,`country`) " +
            "values <foreach collection='list' item='data' index='index' separator=','> " +
            "(#{data.name},#{data.age},#{data.phone},#{data.idcard},#{data.img},#{data.education},#{data.enterprise},#{data.height},#{data.weight},#{data.nation},#{data.country})" +
            "</foreach></script>")
    void insertBatch(@Param("list")List<Encrypt> data);

    @Select("select * from tbl_encrypt where id = #{id}")
    Encrypt getById(@Param("id")Integer id);

    @Select("<script>select * from tbl_encrypt where 1=1 " +
            "<if test='data.phone != null'> and phone = #{data.phone} </if>" +
            "<if test='data.idcard != null'> and idcard = #{data.idcard} </if>" +
            "order by id asc " +
            "<if test='data.pageStart != null and data.pageSize != null'>limit #{data.pageStart},#{data.pageSize} </if>" +
            "</script>")
    List<Encrypt> list(@Param("data")Encrypt data);

}
