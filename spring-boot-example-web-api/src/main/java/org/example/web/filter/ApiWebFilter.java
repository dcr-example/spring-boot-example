package org.example.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/")
public class ApiWebFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(ApiWebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("{}->init()", this.getClass().getName());
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("{}->doFilter()", this.getClass().getName());

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");
//        response.setHeader("Access-Control-Allow-Credentials", "true");  //关键设置
//        response.setHeader("XDomainRequestAllowed","1");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("{}->destroy()", this.getClass().getName());
        Filter.super.destroy();
    }
}
