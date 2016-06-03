package com.ncsoft.platform.report;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncsoft.platform.report.controller.BoardController;
import com.ncsoft.platform.report.domain.Reply;
import com.ncsoft.platform.report.persistence.ReplyDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private ReplyDao dao;
	
	@Test
	public void testCreate() throws Exception {
		Reply reply = new Reply();
		reply.setBno(1);
		reply.setReplytext("테스트 댓글 입력");
		reply.setReplyer("테스터");
		
		dao.create(reply);
	}
	
	@Test
	public void testRead() throws Exception {
		Reply reply = dao.read(1);
		logger.info(reply.getRno() + ":" + reply.getReplyText());
	}
	
	@Test
	public void testList() throws Exception {
		
		List<Reply> list = dao.list(1);
		for(Reply reply: list) {
			logger.info(reply.getRno() + ":" + reply.getReplyText());
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Reply reply = dao.read(1);
		reply.setReplytext("테스트 댓글 업데이트");		
		dao.update(reply);
		
		reply = dao.read(1);
		logger.info(reply.getRno() + ":" + reply.getReplyText());
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}
