package com.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hello.domain.Person;
import com.hello.service.HelloService;

@Controller
@RequestMapping(value="/helloworld")
public class HellowordController {
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/index",method={RequestMethod.GET})
	public String index(HttpServletRequest request) {
		request.setAttribute("hellos", helloService.getHolloworlds());
		return "index";
	}
	
	@RequestMapping(value="/databind",method={RequestMethod.POST})
	public String datebind(@RequestParam("files") MultipartFile[] files,Person person){
		System.out.println(files[0].getOriginalFilename());
		System.out.println(files[1].getOriginalFilename());
		System.out.println(person.getName());
		System.out.println(person.getSons().get(0).getName());
		System.out.println(person.getSons().get(1).getName());
		return "datebind";
	}
	
	@ResponseBody
	@RequestMapping(value = "ajax", produces = "application/json")
	public String ajax(HttpServletRequest request,HttpServletResponse response)
	{
		String getString=request.getParameter("ajaxSendMessage");
		System.out.println(getString);
		return "{\"answer\":\"" + getString + "\"}"; 
	}
}
