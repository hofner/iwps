package com.ericsson.bugs.sdt.dtra.iwp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * The Filter for CORS.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

    /** The Constant ACCESS_CONTROL_ALLOW_ORIGIN. */
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    /** The Constant ALL_ORIGINS. */
    private static final String ALL_ORIGINS = "*";

    /** The Constant ACCESS_CONTROL_ALLOW_METHODS. */
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

    /** The Constant HTTP_METHODS. */
    private static final String HTTP_METHODS = "GET, POST, PATCH, PUT, DELETE, ";

    /** The Constant OPTIONS. */
    private static final String OPTIONS = "OPTIONS";

    /** The Constant ACCESS_CONTROL_ALLOW_HEADERS. */
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

    /** The Constant ALLOWED_HEADERS. */
    private static final String ALLOWED_HEADERS = "ClientId, Origin, Content-Type, token, username, password";

    /** The Constant ACCESS_CONTROL_MAX_AGE. */
    private static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";

    /** The Constant ONE_DAY. */
    private static final String ONE_DAY = "86400";

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // TODO Security flaw on ALL_ORIGINS
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ALL_ORIGINS);
        response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, HTTP_METHODS + OPTIONS);
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, ALLOWED_HEADERS);
        response.setHeader(ACCESS_CONTROL_MAX_AGE, ONE_DAY);
        if (!OPTIONS.equals(request.getMethod())) {
            chain.doFilter(req, res);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing special to do here

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        // nothing special to do here
    }

}
