package online_store_project.servlets;

import online_store_project.dto.ReadUserDto;
import online_store_project.service.UserService;
import online_store_project.util.JspHelper;
import online_store_project.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(UrlPath.USERS_LIST)
public class UsersListServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ReadUserDto> allUsers = USER_SERVICE.findAllUsers();

        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher(JspHelper.getPathToJsp("usersList")).forward(req, resp);
    }
}
