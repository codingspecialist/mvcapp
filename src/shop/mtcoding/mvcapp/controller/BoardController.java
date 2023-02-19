package shop.mtcoding.mvcapp.controller;


import shop.mtcoding.mvcapp.config.ViewResolver;
import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.BoardRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BoardController {
    private BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String list(HttpServletRequest request){
        System.out.println("list : 요청됨");
        List<Board> boardList = boardRepository.findAll();
        request.setAttribute("boardList", boardList);
        return ViewResolver.resolve("/board/list");
    }

    public String saveForm(){
        System.out.println("saveForm : 요청됨");
        return ViewResolver.resolve("/board/saveForm");
    }

    public String save(String title, String content){
        System.out.println("save : 요청됨");
        boardRepository.save(title, content);
        return "/board/list.do";
    }
}
