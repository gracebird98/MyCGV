package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.NoticeVo;

@Repository
public class NoticeDao implements MycgvDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	 * 공지사항 리스트
	 */
	public ArrayList<NoticeVo> select() {
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");
		
		return (ArrayList<NoticeVo>)list;
		
	}
	
	
	/*
	 * 공지사항 상세보기
	 */
	public NoticeVo select(String nid) {
		return sqlSession.selectOne("mapper.notice.content", nid);
		
	}
	
	
	/*
	 * 공지사항 등록하기
	 */
	@Override
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);
	}


	//공지사항 수정처리
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);
		
	}


	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
		
	}
	
	
	/*
	 * 조회수 증가
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.hits", nid);
		
	}
	
	
	
	
	
	/*
	 * 공지사항 리스트 페이징 처리
	 */
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
//		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list",param);
		
		return sqlSession.selectList("mapper.notice.list",param);

	}
	
}









