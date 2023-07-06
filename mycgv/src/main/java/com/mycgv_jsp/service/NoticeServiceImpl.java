package com.mycgv_jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv_jsp.dao.NoticeDao;
import com.mycgv_jsp.vo.NoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	

	@Override
	public ArrayList<NoticeVo> getList(int startCount, int endCount) {
		ArrayList<NoticeVo> nlist = new ArrayList<NoticeVo>();
		List<Object> list = noticeDao.select(startCount, endCount);
		for(Object obj : list) {
			NoticeVo noticeVo = (NoticeVo)obj;
			nlist.add(noticeVo);
			
		}
		return nlist;
	}
	
	@Override
	public ArrayList<NoticeVo> getList() {
		return noticeDao.select();
	}
	
	@Override
	public NoticeVo getContent(String nid) {
		return noticeDao.select(nid);
	}

	@Override
	public void updateHits(String nid) {
		noticeDao.updateHits(nid);
	}

	@Override
	public int insert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}

	@Override
	public int delete(String nid) {
		return noticeDao.delete(nid);
	}

	@Override
	public int update(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}

}
