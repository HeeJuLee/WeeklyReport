package com.ncsoft.platform.report.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ncsoft.platform.report.domain.Reply;
import com.ncsoft.platform.report.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDao dao; 
	
	@Override
	public void regist(Reply reply) throws Exception {
		dao.create(reply);
	}

	@Override
	public List<Reply> list(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modify(Reply reply) throws Exception {
		dao.update(reply);
	}

	@Override
	public void remove(Integer rno) throws Exception {
		dao.delete(rno);
	}

}
