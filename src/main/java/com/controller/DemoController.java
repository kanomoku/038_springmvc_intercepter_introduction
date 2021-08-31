package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo")
	public String domo() {
		System.out.println("执行demo");
		return "index.jsp";
	}
}
