package online_store_project.servlets;

import online_store_project.dto.ReadProductDto;
import online_store_project.dto.ReadUserDto;
import online_store_project.service.ProductService;
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
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(value=UrlPath.BASKET, name = "basket")
@MultipartConfig
public class BasketServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = ProductService.getINSTANCE();
    private static final UserService USER_SERVICE = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String totalPrice = req.getParameter("totalPrice");
        if(totalPrice.equals("0 ₽")){
            req.getSession().setAttribute("error","The basket list is empty");
            resp.sendRedirect(UrlPath.BASKET);
            return;
        }

        Map<String, String[]> productMap = req.getParameterMap();
        ReadUserDto user = (ReadUserDto) req.getSession().getAttribute("user");

        Optional<ReadUserDto> readUserDto = USER_SERVICE.paymentForTheOrder(totalPrice, user.getUsers_id(), productMap);
        if(readUserDto.isPresent()){
            req.getSession().setAttribute("success", "Order completed");
            req.getRequestDispatcher("/deleteBasket").forward(req, resp);
        }
        else{
            req.getSession().setAttribute("error", "Order not completed");
            req.getRequestDispatcher("/deleteBasket").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String success = (String)(req.getSession().getAttribute("success"));
        String error = (String)(req.getSession().getAttribute("error"));

        req.getSession().removeAttribute("error");
        req.getSession().removeAttribute("success");

        req.setAttribute("success", success);
        req.setAttribute("error", error);

        req.getRequestDispatcher(JspHelper.getPathToJsp("basket")).forward(req,resp);
    }

}
