package online_store_project.servlets;

import online_store_project.util.UrlPath;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value=UrlPath.DELETE_BASKET,name="deleteBasket")
public class DeleteBasketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDetailsServlet.removeProductsFromBasketList();
        resp.sendRedirect(UrlPath.BASKET);
    }
}
