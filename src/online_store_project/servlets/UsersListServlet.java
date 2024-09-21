package online_store_project.servlets;

import online_store_project.dto.ReadUserDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(UrlPath.USERS_LIST)
public class UsersListServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        boolean blacklisted = Boolean.parseBoolean(req.getParameter("value").toLowerCase());

        UserService.changeBlackList(userId,blacklisted);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("userId")!=null){
            doPost(req,resp);
            req.removeAttribute("userId");
            req.removeAttribute("blacklisted");
        }

        List<ReadUserDto> allUsers = USER_SERVICE.findAllUsers();

        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher(JspHelper.getPathToJsp("usersList")).forward(req, resp);
    }
}
