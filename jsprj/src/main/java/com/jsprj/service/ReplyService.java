package com.jsprj.service;

import java.util.List;

import com.jsprj.vo.ReplyVO;

public interface ReplyService {
	public void addReply(ReplyVO vo);
	
	public List<ReplyVO> listReply(int bno);
	
	public void modifyReply(ReplyVO vo);
	
	public void removeReply(int rno);
}
