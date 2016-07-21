package com.jsprj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	
	@RequestMapping(value="/list")
	public String board(){
		return "/board/board";
	}
}
