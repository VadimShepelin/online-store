package online_store_project.filter;

import online_store_project.dto.ReadUserDto;
import online_store_project.entity.BlackList;
import online_store_project.util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(UrlPath.MAIN)
public class BlackListFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ReadUserDto user = (ReadUserDto) request.getSession().getAttribute("user");

        if(user.getIs_blacklisted()== BlackList.True){
            request.getSession().invalidate();
            response.sendRedirect(UrlPath.LOGIN+"?blacklist=true");

            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
