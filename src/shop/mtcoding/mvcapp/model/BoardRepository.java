package shop.mtcoding.mvcapp.model;

import shop.mtcoding.mvcapp.config.DB;

import java.util.List;

public class BoardRepository {

    public List<Board> findAll(){
        return DB.selectAll();
    }

    public void save(String title, String content){
        DB.insert(title, content);
    }

}
