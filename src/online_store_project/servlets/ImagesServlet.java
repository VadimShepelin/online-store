package online_store_project.servlets;

import online_store_project.service.ImageService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/images/*")
@MultipartConfig
public class ImagesServlet extends HttpServlet {
    private static final ImageService IMAGE_SERVICE = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] imageBytes = IMAGE_SERVICE.getImageBytes(req.getRequestURI().replace("/images",""));

        resp.setContentType("image/jpeg");
        resp.setContentLength(imageBytes.length);
        resp.getOutputStream().write(imageBytes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
