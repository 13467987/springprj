package com.jsprj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsprj.dao.Criteria;
import com.jsprj.dao.SearchCriteria;
import com.jsprj.vo.BoardVO;

public interface BoardService {
	
	public void create(BoardVO vo);
	
	public BoardVO read(int no);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> listAll();
	
	public List<BoardVO> listCriteria(Criteria cri);
	
	public int listCountPaging(Criteria cri);
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri);
	
	public int listSearchCount(SearchCriteria cri);
	
}
