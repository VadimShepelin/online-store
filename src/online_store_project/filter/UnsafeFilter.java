package online_store_project.filter;

import online_store_project.util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"main","profile","category","productDetails"})
public class UnsafeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getSession().getAttribute("user")!=null){
            filterChain.doFilter(request,servletResponse);
        }

        else{
            ((HttpServletResponse)servletResponse).sendRedirect(UrlPath.LOGIN);
        }
    }

    @Override
    public void destroy() {

    }
}
