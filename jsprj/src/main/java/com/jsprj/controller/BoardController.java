package com.jsprj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsprj.service.BoardService;
import com.jsprj.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list")
	public String board(){
		return "/board/board";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String wirteGET(){
		return "/board/write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String writePOST(BoardVO vo, Model model){
		System.out.println(vo.getContent());
		System.out.println(vo.getTitle());
		System.out.println(vo.getUserID());
		System.out.println(vo.getHit());
		System.out.println(vo.getRegDate());
		service.create(vo);
		
		return "redirect:/board/board";
	}
}
