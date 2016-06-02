package com.ncsoft.platform.report;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ncsoft.platform.report.controller.BoardController;
import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Criteria;
import com.ncsoft.platform.report.domain.SearchCriteria;
import com.ncsoft.platform.report.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
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
		Board board = dao.read(122867);
		System.out.println(board.getWriter());
	}
	
	@Test
	public void testUpdate() throws Exception {
		Board board = new Board();
		board.setBno(1);
		board.setTitle("글 제목 수정");
		board.setContent("내용 수정");
		board.setWriter("작성자 수정");
		
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(4);
	}
	
	@Test
	public void testListAll() throws Exception {
		//List<Board> list = dao.listAll();
	}
	
	@Test
	public void testListPage() throws Exception {
		int page = 3;
		
		List<Board> list = dao.listPage(page);
		
		for(Board board: list) {
			logger.info(board.getBno() + ":" + board.getTitle());
		}
		
	}
	
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(10);
		cri.setPerPageNum(10);
		
		List<Board> list = dao.listCriteria(cri);
		
		for(Board board: list) {
			logger.info(board.getBno() + ":" + board.getTitle());
		}
	}
	
	@Test
	public void testListSearch() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(10);
		cri.setPerPageNum(10);
		cri.setKeyword("제목");
		cri.setSearchType("t");
		
		List<Board> list = dao.listSearch(cri);
		
		for(Board board: list) {
			logger.info(board.getBno() + ":" + board.getTitle());
		}
		
		logger.info("COUNT: " + dao.countSearching(cri));
	}
	
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
}
