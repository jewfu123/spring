package com.yyt.bp.mapper;

import java.util.List;

import com.yyt.bp.pojo.Component;

public interface ComponentMapper {
	
	List<Component> selectAll();
	
	/**
     * 添加
     */
    void add(Component component);
    
    /**
     * 查看详情：根据Id查询
     */
    Component selectById(String id);

}
