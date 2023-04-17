package com.board.bo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.bo.vo.BoardVo;
@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertBoard(Map<String, Object> params) {
	
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("boardMapper.insertBoard", params);
	}

	public List<BoardVo> boardList(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("boardMapper.boardList", boardVo);
	}

	public int boardDelete(ArrayList ss) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("boardMapper.boardDelete", ss);
	}

	public BoardVo boardDetail(int number) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("boardMapper.boardDetail", number);
	}

	public void boardDetail(BoardVo boardVo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("boardMapper.boardUpdate", boardVo);
	}

}
