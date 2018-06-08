package com.ehu.bean;

import lombok.Data;

/**
 * @author geyl
 * @Title: ${CLASS_NAME}
 * @Package com.ehu.bean
 * @Description: TODO
 * @date 2018-6-8 12:34
 */
@Data
public class PageBean {
    private Integer offset;
    private Integer limit;
    private String order;
    private String  sort;
}
