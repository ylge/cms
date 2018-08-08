package com.ehu.bean;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author geyl
 * @Title: ${CLASS_NAME}
 * @Package com.ehu.bean
 * @date 2018-6-7 17:45
 */
public class PageResult<T> implements Serializable {
    public Long total;      //总记录数
    public List<T> rows;  //数据列表

    public PageResult(PageInfo<T> tPageInfo) {
        this.total = tPageInfo.getTotal();
        this.rows = tPageInfo.getList();
    }
}
