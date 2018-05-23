package com.ehu.system.service;



import com.ehu.common.bean.TreeGridNode;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/12.
 * Time:17:40
 * ProjectName:Common-admin
 */
public interface TreeGridService {
    List<TreeGridNode> getMenuTreeGridNodes();
}
