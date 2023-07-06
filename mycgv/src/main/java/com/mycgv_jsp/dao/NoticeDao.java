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
	 * �������� ����Ʈ
	 */
	public ArrayList<NoticeVo> select() {
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");
		
		return (ArrayList<NoticeVo>)list;
		
	}
	
	
	/*
	 * �������� �󼼺���
	 */
	public NoticeVo select(String nid) {
		return sqlSession.selectOne("mapper.notice.content", nid);
		
	}
	
	
	/*
	 * �������� ����ϱ�
	 */
	@Override
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);
	}


	//�������� ����ó��
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);
		
	}


	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
		
	}
	
	
	/*
	 * ��ȸ�� ����
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.hits", nid);
		
	}
	
	
	
	
	
	/*
	 * �������� ����Ʈ ����¡ ó��
	 */
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
//		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list",param);
		
		return sqlSession.selectList("mapper.notice.list",param);

	}
	
}









