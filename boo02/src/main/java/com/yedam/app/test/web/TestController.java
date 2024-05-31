package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	//@RequestMapping(path="/test", method=RequestMethod.GET)  아래와같움
	@GetMapping("test")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : " + keyword;
	}
	
	//@RequestMapping(path="/test", method=RequestMethod.POST)  아래와같움
	@PostMapping("test")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : INSERT - " + keyword;
	}
}
