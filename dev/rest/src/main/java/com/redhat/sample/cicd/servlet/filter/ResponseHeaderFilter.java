package com.redhat.sample.cicd.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:ytsuboi@redhat.com">Yosuke TSUBOI</a>
 * @since 2016/07/05
 */
@WebFilter(filterName = "ResponseHeaderFilter", urlPatterns = { "/*" })
public class ResponseHeaderFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse) response)
                .addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).addHeader(
                "Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
