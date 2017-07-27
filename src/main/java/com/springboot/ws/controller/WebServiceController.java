package com.springboot.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ws.service.WebServices;

/**
 * 
 * @author BL-Y
 * 使用
 * @Controller
 * @ResponseBody
 * 或者使用
 * @RestController
 */
@Controller
@ResponseBody
public class WebServiceController {
	
	@Autowired
	private WebServices helloWorld;
	
	@RequestMapping("hello")
	public String hello(){
		helloWorld.sayHello("王文强");
		helloWorld.save("name", "123456");
		return helloWorld.sayHello("王文强");
	}

}
