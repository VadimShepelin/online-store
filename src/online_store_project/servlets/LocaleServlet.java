package online_store_project.servlets;

import online_store_project.util.UrlPath;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPath.LOCALE)
@MultipartConfig
public class LocaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("locale");
        req.getSession().setAttribute("lang", language);

        String prevPage = req.getHeader("referer");
        String page = prevPage == null ? UrlPath.REGISTRATION : prevPage;

        resp.sendRedirect(page);


    }
}
