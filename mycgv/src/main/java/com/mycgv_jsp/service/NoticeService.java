package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.NoticeVo;

public interface NoticeService {
	public ArrayList<NoticeVo> getList(int startCount, int endCount);
	public NoticeVo getContent(String nid);
	public void updateHits(String nid);
	public int insert(NoticeVo noticeVo);
	public int delete(String nid);
	public int update(NoticeVo noticeVo);
	public ArrayList<NoticeVo> getList();
}
