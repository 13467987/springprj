package com.jsprj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsprj.dao.PageMaker;
import com.jsprj.dao.SearchCriteria;
import com.jsprj.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri,Model model){
		model.addAttribute("list",service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCnt(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker",pageMaker);
	}
}
