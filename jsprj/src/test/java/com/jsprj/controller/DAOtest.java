package com.jsprj.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsprj.dao.BoardDAO;
import com.jsprj.dao.Criteria;
import com.jsprj.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DAOtest {

	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate(){
		BoardVO vo = new BoardVO();
		vo.setTitle("스프링 타이틀");
		vo.setContent("스프링 내용");
		vo.setUserID("스프링아이디");
		dao.create(vo);
		
	}
	
	@Test
	public void testListCri(){
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setBoardCnt(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		for(BoardVO boardVO : list){
			
		}
	}
}
