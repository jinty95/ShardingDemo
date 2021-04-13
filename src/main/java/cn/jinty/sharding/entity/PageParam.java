package cn.jinty.sharding.entity;

import lombok.Data;

/**
 * 分页参数
 *
 * @author jinty
 * @date 2021/4/1
 **/
@Data
public class PageParam {

    //页码
    private Integer pageNum = 1;

    //页面大小
    private Integer pageSize = 10;

    /**
     * 计算分页起点
     * @return 分页起点
     */
    public Integer getPageStart(){
        return (pageNum-1) * pageSize;
    }

}
