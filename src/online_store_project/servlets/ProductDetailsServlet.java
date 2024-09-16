package online_store_project.servlets;

import lombok.Getter;
import online_store_project.dto.ReadProductDto;
import online_store_project.entity.Product;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@WebServlet(value=UrlPath.PRODUCT_DETAILS,name = "productDetails")
@MultipartConfig
public class ProductDetailsServlet extends HttpServlet{
    private static final List<ReadProductDto> basketList = new ArrayList<>();
    private static final ProductService PRODUCT_SERVICE = ProductService.getINSTANCE();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        Optional<ReadProductDto> product = PRODUCT_SERVICE.getProduct(productId);

        if (product.isPresent()) {
            request.setAttribute("product", product.get());
            request.getRequestDispatcher(JspHelper.getPathToJsp("productDetails")).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("basketList")==null) {
            req.getSession().setAttribute("basketList", basketList);
        }

        String productId = req.getParameter("id");
        Optional<ReadProductDto> product = PRODUCT_SERVICE.getProduct(productId);

        if (product.isPresent()) {
            if(isBacketListContainsProduct(product)){
                req.setAttribute("error", "Product already exists");
            }
            else{
                basketList.add(product.get());
                req.setAttribute("success", "Product added successfully");
            }
        }
        else{
            req.setAttribute("error", "Product not found");
        }

       doGet(req, resp);
    }

    private static boolean isBacketListContainsProduct(Optional<ReadProductDto> product) {
        return basketList.stream().anyMatch((item) -> item.getProduct_id() == product.get().getProduct_id());
    }

    public static void removeProductsFromBasketList() {
        Iterator<ReadProductDto> iterator = basketList.iterator();
        while (iterator.hasNext()) {
            ReadProductDto product = iterator.next();
            iterator.remove();
        }
    }
}
