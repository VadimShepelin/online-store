package online_store_project.filter;

import online_store_project.util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(UrlPath.ADMIN_LOGIN)
public class AdminLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestParameter = request.getParameter("admin");
        if((requestParameter != null && requestParameter.equals("login")||request.getSession().getAttribute("login")!=null)) {
            request.getSession().setAttribute("login", requestParameter);
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
