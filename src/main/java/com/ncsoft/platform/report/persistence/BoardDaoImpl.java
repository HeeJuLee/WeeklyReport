package com.ncsoft.platform.report.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Criteria;
import com.ncsoft.platform.report.domain.SearchCriteria;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.ncsoft.platform.report.mapper.boardMapper";
	
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

	@Override
	public List<Board> listPage(Integer page) throws Exception {
		
		if(page <= 0)
			page = 1;
		
		int start = (page - 1) * 10;
		
		return session.selectList(namespace + ".listPage", start);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging() throws Exception {
		return session.selectOne(namespace + ".countPaging");
	}

	@Override
	public List<Board> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int countSearching(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".countSearching", cri);
	}

}
