package com.ncsoft.platform.report.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ncsoft.platform.report.domain.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.ncsoft.platform.report.mapper.BoardMapper";
	
	@Override
	public void create(Board board) throws Exception {
		session.insert(namespace + ".create", board);
	}

	@Override
	public Board read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(Board board) throws Exception {
		session.update(namespace + ".update", board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.update(namespace + ".delete", bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}