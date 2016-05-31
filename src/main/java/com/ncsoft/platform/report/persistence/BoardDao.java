package com.ncsoft.platform.report.persistence;

import java.util.List;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Criteria;

public interface BoardDao {
	public void create(Board board) throws Exception;
	public Board read(Integer bno) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<Board> listAll() throws Exception;
	public List<Board> listPage(Integer page) throws Exception;
	public List<Board> listCriteria(Criteria cri) throws Exception;
	public int countPaging() throws Exception;
}
