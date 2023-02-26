package shop.mtcoding.mvcapp.controller;


import shop.mtcoding.mvcapp.config.ViewResolver;
import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.BoardRepository;
import shop.mtcoding.mvcapp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BoardController {
    private BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String list(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new RuntimeException("로그인되지 않았습니다");
        }
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
        
        if(title == null || title.isEmpty()){
            throw new RuntimeException("title이 없습니다");
        }
        if(content == null || content.isEmpty()){
            throw new RuntimeException("content가 없습니다");
        }
        boardRepository.save(title, content);
        return "/board/list.do";
    }
}
