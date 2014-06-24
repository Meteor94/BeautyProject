package com.beautyProj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beautyProj.model.SystemContext;

/**
 * Servlet Filter implementation class SystemContextFilter
 */
@WebFilter("/SystemContextFilter")
public class SystemContextFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SystemContextFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
	    int offset = 0;
	    try{
	        offset=Integer.parseInt(request.getParameter("pager.offset"));
	    }catch(NumberFormatException e){
	    }
	    try {
            SystemContext.setOffset(offset);
            SystemContext.setSize(15);
            chain.doFilter(request, response);
        } finally{
            SystemContext.removeOffset();
            SystemContext.removeSize();
        }
	    
	    
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
