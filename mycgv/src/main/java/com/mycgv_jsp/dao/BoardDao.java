package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.BoardVo;

@Repository
public class BoardDao implements MycgvDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	 * ��ȸ�� ����
	 */
	public void updateHits(String bid) {
		sqlSession.update("mapper.board.updateHits", bid);
	}
	
	
	/*
	 * delete �Խñ� ����
	 */
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);
	}
	
	
	
	/*
	 * update �Խñ� ������Ʈ
	 */
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}
	
	/*
	 * select �Խñ� �󼼺���
	 */
	public BoardVo select(String bid) {
		return  sqlSession.selectOne("mapper.board.select", bid);
	}
	
	
	/*
	 * select �Խñ� ��ü ����Ʈ
	 */
	public ArrayList<BoardVo> select() {
		List<BoardVo> list= sqlSession.selectList("mapper.board.list2");
		return (ArrayList<BoardVo>)list;
	}
	
	
	
	
	/*
	 * insert �Խñ� ���
	 */
	@Override
	public int insert(Object boardVo) {
		return sqlSession.insert("mapper.board.insert", boardVo);
	}

	
	
	

	
	/*
	 * select �Խñ� ��ü ����Ʈ ����¡ ó�� startCount, endCount
	 */
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		//List<BoardVo> list = sqlSession.selectList("mapper.board.list", param);
		
		return sqlSession.selectList("mapper.board.list", param);
		
	}
	
	
	
	
}
