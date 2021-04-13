package cn.jinty.sharding.dao;

import cn.jinty.sharding.entity.Sharding;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * DAO
 *
 * @author jinty
 * @date 2021/3/18
 **/
@Mapper
@Repository
public interface ShardingMapper {

    @Insert("insert into tbl(`id`,`name`,`description`) values(#{data.id},#{data.name},#{data.description})")
    void insert(@Param("data")Sharding data);

    @Insert("insert into tbl(`name`,`description`) values(#{data.name},#{data.description})")
    void insertWithNoId(@Param("data")Sharding data);

    @Select("select * from tbl where id = #{id}")
    Sharding selectById(@Param("id")Long id);

}
