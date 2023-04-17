package com.board.bo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.bo.service.BoardService;
import com.board.bo.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boardRegist")
public String boardRegist() {
	return "/board/BoardRegist";
}

 @PostMapping("/boardRegistAction")
 public ModelAndView boardRegistAction(@RequestBody Map<String,Object> params) {
	 
		ModelAndView model = new ModelAndView();

		// view 에서 db 보낸거
		boardService.insertBoard(params);

		model.setViewName("jsonView");
		return model;
	}

  @GetMapping("/boardList")
  public String boardList() {
	  
	  return "board/boardList";
  }
  @GetMapping("/boardListAction")
    public ModelAndView boardList(BoardVo boardVo) {

		ModelAndView model = new ModelAndView();
		List<BoardVo> boardList = boardService.boardList(boardVo);

		model.addObject("result", boardList);
		model.setViewName("jsonView");
		return model;
	}
	 @PostMapping("/boardDelete")
    public ModelAndView boardDelete(@RequestBody Map<String ,Object> params) {

		ModelAndView model = new ModelAndView();

		ArrayList ss = (ArrayList) params.get("array");
		int cnt = 0;

		if (ss.size() > 0) {
			System.out.println("============" + ss.size());
			cnt = boardService.boardDelete(ss);

		}

		model.addObject("cnt", cnt);
		model.setViewName("jsonView");
		return model;

	}
	
	 @GetMapping("/boardDetail")
	 public ModelAndView   boardDetail(@RequestParam Map<String ,Object> params){

			ModelAndView model = new ModelAndView();

			String boardIdx = (String) params.get("click.idx ");
//				int number = Integer.parseInt(boardIdx);
			int number = Integer.parseInt(boardIdx);
			BoardVo boardVo = boardService.boardDetail(number);

			model.addObject("userInfo", boardVo);

			return model;
	
	 }
	 
	 @PostMapping("/boardUpdate")
	 public String boardUpdate(@ModelAttribute("boardVo") BoardVo boardVo) {
		 
				ModelAndView model = new ModelAndView();

				boardService.boardUpdate(boardVo);
			
			 return "redirect:/board/boardList";
			 
		 }
	}