package com.board.bo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.bo.dao.BoardDao;
import com.board.bo.vo.BoardVo;

@Service
public class BoardService {

@Autowired
private BoardDao boardDao;

public void insertBoard(Map<String, Object> params) {
	// TODO Auto-generated method stub
	boardDao.insertBoard(params);
}

public List<BoardVo> boardList(BoardVo boardVo) {
	// TODO Auto-generated method stub
	return boardDao.boardList(boardVo);
}

public int boardDelete(ArrayList ss) {
	// TODO Auto-generated method stub
	return boardDao.boardDelete(ss);
	}

public BoardVo boardDetail(int number) {
	// TODO Auto-generated method stub
	return boardDao.boardDetail(number);
}

public void boardUpdate(BoardVo boardVo) {
	// TODO Auto-generated method stub
	boardDao.boardDetail(boardVo);
}


}