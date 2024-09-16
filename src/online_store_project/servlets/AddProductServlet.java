package online_store_project.servlets;

import online_store_project.dto.UpdateProductDto;
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

@WebServlet(value=UrlPath.ADD_PRODUCT,name="addProduct")
@MultipartConfig(fileSizeThreshold = 1024*1024)
public class AddProductServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = ProductService.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateProductDto updateProductDto = UpdateProductDto.builder()
                .categoryId((Integer.parseInt(req.getParameter("category"))))
                .product_name((req.getParameter("name")))
                .stock(Integer.parseInt(req.getParameter("stock")))
                .description(req.getParameter("description"))
                .image(req.getPart("image"))
                .old_price(req.getParameter("price"))
                .discount(req.getParameter("discount"))
                .build();

        Integer result = PRODUCT_SERVICE.saveProduct(updateProductDto);
        if(result!=0){
            req.setAttribute("success","Product added successfully");
            req.getRequestDispatcher(JspHelper.getPathToJsp("addProduct")).forward(req, resp);
        }
        else{
            req.setAttribute("fail", "Failed to add product");
            req.getRequestDispatcher(JspHelper.getPathToJsp("addProduct")).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPathToJsp("addProduct")).forward(req,resp);
    }
}
