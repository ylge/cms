package com.ehu.system.service.impl;

import com.ehu.common.bean.TreeGridNode;
import com.ehu.common.bean.entity.system.SysMenu;
import com.ehu.system.service.MenuService;
import com.ehu.system.service.TreeGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/12.
 * Time:17:41
 * ProjectName:Common-admin
 */
@Service
public class TreeGridServiceImpl implements TreeGridService {

    @Autowired
    private MenuService menuService;

    @Override
    public List<TreeGridNode> getMenuTreeGridNodes() {
        List<SysMenu> list = menuService.getMenu();
        List<TreeGridNode> treeGridNodeList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            list.forEach(menu -> {
                TreeGridNode treeNode = new TreeGridNode();
                treeNode.setId(menu.getId());
                treeNode.setName(menu.getName());
                treeNode.setUrl(menu.getUrl());
                if (menu.getId()==1) {
                    treeNode.set_parentId(null);
                } else {
                    treeNode.set_parentId(menu.getParentId());
                }
                treeNode.setLevel(menu.getLevel());
                treeNode.setSort(menu.getSort());
                treeNode.setCreateDate(menu.getCreateTime());
                treeGridNodeList.add(treeNode);
            });
            treeGridNodeList.sort((o1, o2) -> {
                if (o1.getSort()==o2.getSort()){
                    return 0;
                }
                if (o1.getSort() > o2.getSort()){
                    return 1;
                }
                return -1;
            });
        }
        return treeGridNodeList;
    }
}
