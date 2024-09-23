package online_store_project.filter;

import online_store_project.util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"admin","addProduct","adminLogout","ordersHistoryAdmin","usersList"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getSession().getAttribute("admin") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            ((HttpServletResponse)servletResponse).sendRedirect(UrlPath.REGISTRATION);
        }
    }

    @Override
    public void destroy() {

    }
}
