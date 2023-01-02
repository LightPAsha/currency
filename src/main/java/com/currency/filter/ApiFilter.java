package com.currency.filter;

import com.currency.http.ConnectionCheckApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class ApiFilter implements Filter {

    private final String API_KEY = "api-key";

    @Autowired
    private ConnectionCheckApiKey connectionCheckApiKey;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = ((HttpServletRequest) req).getRequestURI();
        if (path.startsWith("/checkApiKey")) {
            filterChain.doFilter(servletRequest, servletResponse); // Just continue chain.
            return;
        }
        String apiKey = req.getHeader(API_KEY);
        boolean correct = connectionCheckApiKey.checkApiKey(apiKey);

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        if (!correct) {
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "apiKey must not be null");
            System.out.println("Error, because apikey cannot be null");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
