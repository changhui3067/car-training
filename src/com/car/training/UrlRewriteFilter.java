package com.car.training;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by I309994 on 12/20/2016.
 */
public class UrlRewriteFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse response = (HttpServletResponse) res;
        response.sendRedirect("/website/index");
//        if (requestURI.startsWith("/Check_License/Dir_My_App/")) {
//        req.getRequestDispatcher("/website/index").forward(req, res);
        chain.doFilter(req, res);

//        } else {
//            chain.doFilter(req, res);
//        }
    }

    @Override
    public void destroy() {
        //
    }
}