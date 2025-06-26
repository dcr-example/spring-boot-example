package org.example.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/")
public class AdminWebFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(AdminWebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("{}->init()", this.getClass().getName());
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("{}->doFilter()", this.getClass().getName());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("{}->destroy()", this.getClass().getName());
        Filter.super.destroy();
    }
}
