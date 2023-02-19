package shop.mtcoding.mvcapp;

import shop.mtcoding.mvcapp.controller.BoardController;
import shop.mtcoding.mvcapp.model.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// GET -> http://localhost:8080/board/list.do
// GET -> http://localhost:8080/board/saveForm.do
// POST -> http://localhost:8080/board/save.do
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String path = getPath(req);
        String action = getAction(req);

        BoardRepository boardRepository = new BoardRepository();
        BoardController boardCon = new BoardController(boardRepository);

        if (path.equals("board")) {
            switch (action) {
                case "saveForm":
                    String saveFormView = boardCon.saveForm();
                    req.getRequestDispatcher(saveFormView).forward(req, resp);
                    break;
                case "save":
                    String method = req.getMethod();
                    if(!method.equals("POST")){
                        resp.setContentType("text/html; charset=utf-8");
                        resp.getWriter().println("POST로 요청해야 합니다");
                        break;
                    }
                    String title = req.getParameter("title");
                    String content = req.getParameter("content");
                    String saveRedirect = boardCon.save(title, content);
                    resp.sendRedirect(saveRedirect);
                    break;
                case "list":
                    String listView = boardCon.list(req);
                    req.getRequestDispatcher(listView).forward(req, resp);
                    break;
                default:
                    resp.sendRedirect("/board/list.do");
            }
        }
    }

    private String getPath(HttpServletRequest req) {
        String path = getUri(req).split("/")[0];
        //System.out.println(path);
        return path;
    }

    private String getAction(HttpServletRequest req) {
        String action = getUri(req).split("/")[1];
        action = action.replace(".do", "");
        //System.out.println(action);
        return action;
    }

    private String getUri(HttpServletRequest req) {
        String uri = req.getRequestURI();
        uri = uri.substring(1);
        return uri;
    }
}
