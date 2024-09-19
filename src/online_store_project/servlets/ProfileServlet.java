package online_store_project.servlets;

import online_store_project.dto.ReadUserDto;
import online_store_project.dto.UpdateUserDto;
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
import java.util.Optional;

@WebServlet(value = UrlPath.PROFILE, name = "profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReadUserDto readUserDto = (ReadUserDto) req.getSession().getAttribute("user");
        String phone = req.getParameter("phone");

        UpdateUserDto updateUserDto = UpdateUserDto.builder()
                .users_id(readUserDto.getUsers_id())
                .phone(phone.isEmpty()||phone.equals("no phone") ? "no phone" : req.getParameter("phone"))
                .email(req.getParameter("email"))
                .address(req.getParameter("address").isEmpty() ? "no address" : req.getParameter("address"))
                .birthday(req.getParameter("birthday"))
                .gender(req.getParameter("gender"))
                .user_name(req.getParameter("name"))
                .user_password(req.getParameter("password"))
                .balance(req.getParameter("balance"))
                .surname(req.getParameter("surname").isEmpty() ? "no surname" : req.getParameter("surname"))
                .build();

        try {
            USER_SERVICE.changeUserData(updateUserDto);
            req.setAttribute("update", "Data saved successfully");
        } catch (ValidationException exception) {
            req.setAttribute("errors", exception.getErrors());
        } finally {
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReadUserDto sessionUser = (ReadUserDto) req.getSession().getAttribute("user");
        Optional<ReadUserDto> user = USER_SERVICE.findUserById(sessionUser.getUsers_id());

        if (user.isPresent()) {
            req.setAttribute("genders", List.of("Male", "Female"));
            req.getSession().setAttribute("profile", user.get());
        }

        req.getRequestDispatcher(JspHelper.getPathToJsp("profile")).forward(req, resp);
    }
}
