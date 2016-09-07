package com.jsprj.dao;

import java.util.List;

import com.jsprj.vo.ReplyVO;

public interface ReplyDAO {
	
	public List<ReplyVO> list(int bno);
	
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(int rno);
	
}
