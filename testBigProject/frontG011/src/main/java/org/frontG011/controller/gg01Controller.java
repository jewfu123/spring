package org.frontG011.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itheima.services.gg01;

@Controller
public class gg01Controller {

	private gg01 service;

	public gg01 getService() {
		return service;
	}
	
	@Autowired
	public void setService(gg01 service) {
		this.service = service;
	}
	
	@GetMapping("/hellome")
	public String Hellome(Model model) {
		model.addAttribute("message", "Hello Thymeleaf!!!");
		HashMap<String, String> inputMap = new HashMap<>();
		inputMap.put("name", "jewfu");
		inputMap.put("age", "18");
		inputMap.put("address", "Japan Tokyo");
		model.addAttribute("info", inputMap);
		//service.Hellome(model);
		return "hello";
	}
	
	@GetMapping("/listall")
	public String ListAll(Model model) throws IOException {
//		DoTestMybatis ddt = new DoTestMybatis();
//    	List<Component> td = ddt.ListAll();
//    	model.addAttribute("showBody", td);
//    	System.out.println(td);
		service.getListAll(model);
		return "showlist";
	}
}
