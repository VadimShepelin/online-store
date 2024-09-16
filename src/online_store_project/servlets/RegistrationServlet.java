package online_store_project.servlets;

import online_store_project.dto.CreateUserDto;
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
import java.util.List;

@WebServlet(UrlPath.REGISTRATION)
@MultipartConfig(fileSizeThreshold = 1024*1024)
public class RegistrationServlet extends HttpServlet {
    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genders", List.of("Male","Female"));
        req.setAttribute("roles", List.of("Admin","User"));

        req.getRequestDispatcher(JspHelper.getPathToJsp("registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreateUserDto userDto = CreateUserDto.builder()
                .email(req.getParameter("email"))
                .user_password(req.getParameter("password"))
                .gender(req.getParameter("gender"))
                .user_name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .build();

        try {
            userService.createUser(userDto);
            req.getRequestDispatcher(JspHelper.getPathToJsp("login")).forward(req, resp);
        }
        catch (ValidationException ex){
            req.setAttribute("genders", List.of("Male","Female"));
            req.setAttribute("roles", List.of("Admin","User"));
            req.setAttribute("errors", ex.getErrors());

            req.getRequestDispatcher(JspHelper.getPathToJsp("registration")).forward(req, resp);
        }


    }}
