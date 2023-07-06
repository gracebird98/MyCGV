package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.BoardVo;

public interface BoardService {
	public ArrayList<BoardVo> getSelect(int startCount, int endCount);
	public BoardVo getSelect(String bid);
	public int getUpdate(BoardVo boardVo);
	int getDelete(String bid);
	int getInsert(BoardVo boardVo);
	public void getUpdateHits(String bid);
}
