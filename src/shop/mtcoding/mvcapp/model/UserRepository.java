package shop.mtcoding.mvcapp.model;

import shop.mtcoding.mvcapp.config.DB;

public class UserRepository {

    public User login(String username, String password){
        return DB.login(username, password);
    }

    public void join(String username, String password, String email){
        DB.join(username, password, email);
    }

}
