package com.jsprj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jsprj.dao.ReplyDAO;
import com.jsprj.vo.ReplyVO;

@Service
public class ReplyServiceImp implements ReplyService {
	
	@Inject
	private ReplyDAO dao;

	@Override
	public void addReply(ReplyVO vo) {
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		dao.update(vo);
	}

	@Override
	public void removeReply(int rno) {
		dao.delete(rno);
	}

}
