package com.jsprj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jsprj.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.jsprj.mappers.ReplyMapper";

	@Override
	public List<ReplyVO> list(int bno) {
		return session.selectList(namespace+".list",bno);
	}

	@Override
	public void create(ReplyVO vo) {
		 session.insert(namespace+".create",vo);
	}

	@Override
	public void update(ReplyVO vo) {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(int rno) {
		session.delete(namespace+".delete",rno);
	}

}
