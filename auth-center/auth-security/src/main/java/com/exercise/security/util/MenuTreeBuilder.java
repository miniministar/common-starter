package com.exercise.security.util;


import com.google.common.collect.Lists;
import com.exercise.security.model.SysMenu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuTreeBuilder {

    public static Set<SysMenu> buildTree(Set<SysMenu> allNodes) {
        // 根节点
        Set<SysMenu> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (Long.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }


    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    private static SysMenu findChildren(SysMenu treeNode, Set<SysMenu> treeNodes) {
        for (SysMenu it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    public static List<SysMenu> buildMenuTree(List<SysMenu> allNodes) {
        // 根节点
        List<SysMenu> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (Long.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });

        //对根节点排序
        List<SysMenu> sortedList = root.stream().sorted( Comparator.comparing( SysMenu::getSort ) ).collect( Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll( sortedList );
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static SysMenu findMenuChildren(SysMenu treeNode, List<SysMenu> treeNodes) {
        for (SysMenu it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(String.valueOf(it.getParentId())) ) {
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<SysMenu> childrenSorted = treeNode.getChildren().stream().sorted( Comparator.comparing( SysMenu::getSort ) ).collect( Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll( childrenSorted );
        return treeNode;
    }


}
