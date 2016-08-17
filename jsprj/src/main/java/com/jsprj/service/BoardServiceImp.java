package com.jsprj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jsprj.dao.BoardDAO;
import com.jsprj.dao.Criteria;
import com.jsprj.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public void create(BoardVO vo) {
		dao.create(vo);
	}

	@Override
	public BoardVO read(int no) {
		// TODO Auto-generated method stub
		return dao.read(no);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
	}

	@Override
	public List<BoardVO> listAll() {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountPaging(Criteria cri) {
		return dao.countPaging(cri);
	}

}
