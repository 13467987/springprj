package com.jsprj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsprj.dao.PageMaker;
import com.jsprj.dao.SearchCriteria;
import com.jsprj.service.BoardService;
import com.jsprj.vo.BoardVO;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri,Model model){
		model.addAttribute("list",service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCnt(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker",pageMaker);
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("no") int no, @ModelAttribute("cri") SearchCriteria cri,Model model){
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(int no ,@RequestParam("cri") SearchCriteria cri,Model model){
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(BoardVO vo , SearchCriteria cri,RedirectAttributes rttr){
		service.update(vo);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("boardCnt",cri.getBoardCnt());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/sboard/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("no") int no,SearchCriteria cri,RedirectAttributes rttr){
		service.delete(no);
		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("boardCnt",cri.getBoardCnt());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/sboard/list";
	}
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public void writeGET(){
	}
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String writePOST(BoardVO vo ){
		service.create(vo);
		
		return "redirect:/sboard/list";
	}
	
}
