package online_store_project.servlets;

import online_store_project.dto.ReadProductDto;
import online_store_project.service.ProductService;
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

@WebServlet(name="category",value=UrlPath.CATEGORY)
@MultipartConfig
public class CategoryServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = ProductService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryIdParameter = req.getParameter("categoryId");
        List<ReadProductDto> readProductDtos = PRODUCT_SERVICE.getProducts(categoryIdParameter);
        req.setAttribute("productList", readProductDtos);

        req.getRequestDispatcher(JspHelper.getPathToJsp("category")).forward(req, resp);
    }
}
