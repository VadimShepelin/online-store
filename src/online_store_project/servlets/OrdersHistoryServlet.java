package online_store_project.servlets;

import online_store_project.dto.ReadOrderDto;
import online_store_project.dto.ReadUserDto;
import online_store_project.service.OrderService;
import online_store_project.util.JspHelper;
import online_store_project.util.UrlPath;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value=UrlPath.ORDERS_HISTORY,name = "ordersHistory")
public class OrdersHistoryServlet extends HttpServlet {
    private static final OrderService ORDER_SERVICE = OrderService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReadUserDto user = (ReadUserDto)req.getSession().getAttribute("user");
        int usersId = user.getUsers_id();

        List<ReadOrderDto> orders = ORDER_SERVICE.findOrders(usersId);
        req.setAttribute("orders", orders);

        req.getRequestDispatcher(JspHelper.getPathToJsp("ordersHistory")).forward(req,resp);
    }
}
