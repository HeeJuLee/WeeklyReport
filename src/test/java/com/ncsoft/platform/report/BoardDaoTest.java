package com.ncsoft.platform.report;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {

	@Inject
	private BoardDao dao;
	
	@Test
	public void testCreate() throws Exception {
		Board board = new Board();
		board.setTitle("새로운 글 제목");
		board.setContent("내용입니다");
		board.setWriter("user00");
		
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
		Board board = dao.read(3);
		System.out.println(board.getWriter());
	}
	
	@Test
	public void testUpdate() throws Exception {
		Board board = new Board();
		board.setBno(1);
		board.setTitle("글 제목 수정");
		board.setContent("내용 수정");
		
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(4);
	}
	
	@Test
	public void testListAll() throws Exception {
		List<Board> list = dao.listAll();
	}
}
