package com.ncsoft.platform.report.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.ncsoft.platform.report.mapper.replyMapper";
	
	@Override
	public void create(Reply reply) throws Exception {
		session.insert(namespace + ".create", reply);
	}

	@Override
	public Reply read(Integer rno) throws Exception {
		return session.selectOne(namespace + ".read", rno);
	}
	
	@Override
	public List<Reply> list(Integer bno) throws Exception {
		return session.selectList(namespace + ".list", bno);
	}

	@Override
	public void update(Reply reply) throws Exception {
		session.update(namespace + ".update", reply);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.update(namespace + ".delete", rno);
	}
	

}
