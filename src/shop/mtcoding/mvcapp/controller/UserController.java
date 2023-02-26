package shop.mtcoding.mvcapp.controller;


import shop.mtcoding.mvcapp.config.ViewResolver;
import shop.mtcoding.mvcapp.model.User;
import shop.mtcoding.mvcapp.model.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String joinForm(){
        return ViewResolver.resolve("/user/joinForm");
    }

    public String loginForm(){
        return ViewResolver.resolve("/user/loginForm");
    }

    public String join(String username, String password, String email){
        if(username == null || username.isEmpty()){
            throw new RuntimeException("username이 없습니다");
        }
        if(password == null || password.isEmpty()){
            throw new RuntimeException("password가 없습니다");
        }
        if(email == null || email.isEmpty()){
            throw new RuntimeException("email이 없습니다");
        }
        userRepository.join(username, password, email);
        return "/user/loginForm.do";
    }

    public String login(String username, String password, HttpServletRequest request){
        if(username == null || username.isEmpty()){
            throw new RuntimeException("username이 없습니다");
        }
        if(password == null || password.isEmpty()){
            throw new RuntimeException("password가 없습니다");
        }
        User userPS = userRepository.login(username, password);
        if(userPS == null){
            throw new RuntimeException("비밀번호 패스워드가 일치하지 않습니다");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", userPS);
        return "/board/list.do";
    }
}
