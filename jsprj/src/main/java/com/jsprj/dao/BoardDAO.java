package com.jsprj.dao;

import java.util.List;

import com.jsprj.vo.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo);
	
	public BoardVO read(int no);
	
	public void update(BoardVO vo);
	
	public void delete(int no);
	
	public List<BoardVO> listAll();
	
	public List<BoardVO> listPage(int page);
	
	public List<BoardVO> listCriteria(Criteria cri);
	
	public int countPaging(Criteria cri);
	
}
