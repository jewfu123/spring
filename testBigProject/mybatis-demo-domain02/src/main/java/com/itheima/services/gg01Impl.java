package com.itheima.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.yyt.bp.mapper.ComponentMapper;
import com.yyt.bp.pojo.Component;

@Service("gg01")
public class gg01Impl implements gg01 {

	@Override
	public void getListAll(Model model) throws IOException {
		//DoTestMybatis ddt = new DoTestMybatis();
		ComponentMapper cMapper = null;
    	List<Component> td = cMapper.selectAll();
    	model.addAttribute("showBody", td);
    	System.out.println(td);
	}

	@Override
	public void Hellome(Model model) {
		HashMap<String, String> inputMap = new HashMap<>();
		inputMap.put("name", "jewfu444");
		inputMap.put("age", "18444");
		inputMap.put("address", "Japan Tokyo444");
		model.addAttribute("info", inputMap);
		//return model;
	}
	
}
