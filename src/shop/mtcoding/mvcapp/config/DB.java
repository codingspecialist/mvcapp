package shop.mtcoding.mvcapp.config;

import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static List<Board> boardList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();

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

    public static void join(String username, String password, String email){
        int id = userList.size()+1;
        User user = new User(id, username, password, email);
        userList.add(user);
    }

    public static User login(String username, String password){
        for (User user: userList) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }


}
