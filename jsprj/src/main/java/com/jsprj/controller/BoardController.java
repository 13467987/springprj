package com.jsprj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsprj.service.BoardService;
import com.jsprj.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list")
	public String board(Model model){
		
		model.addAttribute("list",service.listAll());
		return "/board/board";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String wirteGET(){
		return "/board/write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String writePOST(BoardVO vo, Model model){
		service.create(vo);
		
		return "redirect:/board/list";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("no") int no, Model model){
		
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("no") int no,Model model){
		model.addAttribute(service.read(no));
	}	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr){
		
		service.update(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("no") int no){
		service.delete(no);
		return "redirect:/board/list";
	}
}
