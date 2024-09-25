package online_store_project.servlets;

import lombok.SneakyThrows;
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
import java.util.Optional;

@WebServlet(value=UrlPath.REPLENISHMENT, name="replenishment")
@MultipartConfig
public class ReplenishmentServlet extends HttpServlet {

    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPathToJsp("replenishment")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        isParametersValid(req,resp);

        String amount = !req.getParameter("customAmount").equals("")?req.getParameter("customAmount"):req.getParameter("amount");
        int userId = ((ReadUserDto)req.getSession().getAttribute("user")).getUsers_id();

        Optional<ReadUserDto> user = USER_SERVICE.replenishBalance(amount, userId);
        if(user.isPresent()) {
            req.getServletContext().setAttribute("balance", user.get().getBalance());
            req.setAttribute("success", "The balance has been successfully replenished");
            doGet(req, resp);
        }

        else{
            req.setAttribute("error", "ERROR: No such user");
            doGet(req, resp);
        }
    }

    @SneakyThrows
    private void isParametersValid(HttpServletRequest request, HttpServletResponse response){

        if(request.getParameter("amount")==null&&request.getParameter("customAmount").isEmpty()) {
            request.setAttribute("error", "ERROR: You haven't chosen payment amount");
            doGet(request,response);
        }
    }
}
