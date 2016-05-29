package com.ncsoft.platform.report.persistence;

import java.util.List;

import com.ncsoft.platform.report.domain.Board;

public interface BoardDao {
	public void create(Board board) throws Exception;
	public Board read(Integer bno) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<Board> listAll() throws Exception;
}
