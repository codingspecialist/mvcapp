package shop.mtcoding.mvcapp.config;

import shop.mtcoding.mvcapp.model.Board;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static List<Board> boardList = new ArrayList<>();

    static {
        boardList.add(new Board(1, "제목 ", "내용"));
        boardList.add(new Board(2, "제목 ", "내용"));
    }

    public static List<Board> selectAll(){
        return boardList;
    }

    public static void insert(String title, String content){
        int id = boardList.size()+1;
        boardList.add(new Board(id, title, content));
    }
}
