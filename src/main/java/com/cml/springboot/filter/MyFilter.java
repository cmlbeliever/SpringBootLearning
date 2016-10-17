package com.cml.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 目前只能通过类名命名来设置执行顺序
 * @author team-lab
 *
 */
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		System.out.println("=============================dofilter===============================");

	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("=============================init===============================");
	}

}
