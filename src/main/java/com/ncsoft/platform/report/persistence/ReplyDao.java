package com.ncsoft.platform.report.persistence;

import java.util.List;

import com.ncsoft.platform.report.domain.Reply;

public interface ReplyDao {

	public void create(Reply reply) throws Exception;
	public Reply read(Integer rno) throws Exception;
	public List<Reply> list(Integer bno) throws Exception;
	public void update(Reply reply) throws Exception;
	public void delete(Integer rno) throws Exception;	
	
}
