package online_store_project.servlets;

import online_store_project.service.AdminService;
import online_store_project.util.JspHelper;
import online_store_project.util.UrlPath;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPath.ADMIN_LOGIN)
@MultipartConfig
public class AdminLoginServlet extends HttpServlet {

    private static final AdminService ADMIN_SERVICE = AdminService.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ADMIN_SERVICE.checkAdmin(req.getParameter("name"),req.getParameter("password"))) {
            req.getSession().setAttribute("admin", req.getParameter("name"));
            resp.sendRedirect(UrlPath.ADMIN);
        }
        else{
            req.setAttribute("error","You are not allowed to access this resource");
            req.getRequestDispatcher(JspHelper.getPathToJsp("adminLogin")).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPathToJsp("adminLogin")).forward(req,resp);
    }
}
