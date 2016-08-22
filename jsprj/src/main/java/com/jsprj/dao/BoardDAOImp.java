package com.jsprj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jsprj.vo.BoardVO;


@Repository
public class BoardDAOImp implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace
	= "com.jsprj.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVO read(int no) {
		return session.selectOne(namespace+".read",no);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(int no) {
		session.delete(namespace+".delete",no);
	}

	@Override
	public List<BoardVO> listAll() {
		
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) {
		if(page <= 0){
			page = 1;
	}
		page = (page - 1)*10;
		
		return session.selectList(namespace+".listPage",page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		return session.selectList(namespace+".listCriteria",cri);
	}

	@Override
	public int countPaging(Criteria cri) {
		return session.selectOne(namespace+".countPaging",cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) {
		return session.selectList(namespace+".listSearch",cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) {
		return session.selectOne(namespace+".listSearchCount",cri);
	}

	
}
