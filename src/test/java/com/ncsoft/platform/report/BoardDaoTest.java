package com.ncsoft.platform.report;

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
}
