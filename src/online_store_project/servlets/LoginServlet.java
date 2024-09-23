package online_store_project.servlets;

import online_store_project.dto.ReadUserDto;
import online_store_project.exception.ValidationException;
import online_store_project.service.UserService;
import online_store_project.util.JspHelper;
import online_store_project.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(UrlPath.LOGIN)
@MultipartConfig
public class LoginServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<ReadUserDto> readUserDto = USER_SERVICE.findUser(email, password);

        if(readUserDto.isPresent()) {
            req.getSession().setAttribute("user", readUserDto.get());
            resp.sendRedirect(UrlPath.MAIN);
        }
        else{
            req.setAttribute("error","Error:User Was Not Found");
            req.getRequestDispatcher(JspHelper.getPathToJsp("login")).forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("blacklist")!=null){
            req.setAttribute("error","Error:User Was Banned");
        }

        req.getRequestDispatcher(JspHelper.getPathToJsp("login")).forward(req,resp);
    }
}
