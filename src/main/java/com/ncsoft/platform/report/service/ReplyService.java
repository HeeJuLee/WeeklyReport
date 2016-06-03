package com.ncsoft.platform.report.service;

import java.util.List;

import com.ncsoft.platform.report.domain.Reply;

public interface ReplyService {

	public void regist(Reply reply) throws Exception;
	public List<Reply> list(Integer bno) throws Exception;
	public void modify(Reply reply) throws Exception;
	public void remove(Integer rno) throws Exception;

}
