package com.ncsoft.platform.report.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Criteria;
import com.ncsoft.platform.report.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao dao;
	
	@Override
	public void regist(Board board) throws Exception {
		dao.create(board);	
	}

	@Override
	public Board read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(Board board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging() throws Exception {
		return dao.countPaging();
	}
}
