package online_store_project.servlets;

import online_store_project.dto.ReadOrderDto;
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

@WebServlet(UrlPath.ORDERS_HISTORY_ADMIN)
public class OrdersHistoryAdminServlet extends HttpServlet {
    private static final OrderService ORDER_SERVICE = OrderService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.valueOf(req.getParameter("userId"));

        List<ReadOrderDto> orders = ORDER_SERVICE.findOrders(userId);
        req.setAttribute("orders", orders);

        req.getRequestDispatcher(JspHelper.getPathToJsp("ordersHistoryAdmin")).forward(req,resp);
    }
}
