package com.ehu.base.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.BaseService;
import com.ehu.bean.PageBean;
import com.ehu.bean.ShiroUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * @author geyl
 * @date 2017/12/13.
 */
@Slf4j
public abstract class BaseServiceImpl<T, E extends Serializable> implements BaseService<T, E> {

    /**
     * general field(通用字段)
     */
    private static final String CREATE_BY = "createBy";

    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_BY = "updateBy";

    private static final String UPDATE_TIME = "updateTime";

    public abstract BaseMapper<T, E> getMappser();

    @Override
    public int deleteByPrimaryKey(E id) {
        return getMappser().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        record = addValue(record, true);
        return getMappser().insert(record);
    }

    /**
     * 通用注入创建 更新信息 可通过super调用
     *
     * @param record
     * @param flag
     * @return
     */
    public T addValue(T record, boolean flag) {
        ShiroUser currentUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        //统一处理公共字段
        Class<?> clazz = record.getClass();
        String operator, operateDate;
        try {
            if (flag) {
                operator = CREATE_BY;
                operateDate = CREATE_TIME;
            } else {
                operator = UPDATE_BY;
                operateDate = UPDATE_TIME;

            }
            Field field = clazz.getDeclaredField(operator);
            field.setAccessible(true);
            field.set(record, currentUser.getName());
            Field fieldDate = clazz.getDeclaredField(operateDate);
            fieldDate.setAccessible(true);
            fieldDate.set(record, new Date());

        } catch (NoSuchFieldException e) {
            //无此字段
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public int insertSelective(T record) {
        record = addValue(record, true);
        return getMappser().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(E id) {
        return getMappser().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        record = addValue(record, false);
        return getMappser().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record = addValue(record, false);
        return getMappser().updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectListByPage(T record) {
        return getMappser().selectListByPage(record);
    }

    /**
     * 公共展示类
     *
     * @param t     实体
     * @param page  页
     * @param limit 行
     * @return
     */
    @Override
    public PageBean<T> show(T t, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<T> tList = getMappser().selectListByPage(t);
        PageBean<T> pageBean = new PageBean<>(new PageInfo<>(tList));
        return pageBean;
    }

}
