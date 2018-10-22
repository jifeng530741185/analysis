package com.unicom.sale.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
* Created by kangb on 2016/5/10.
*/
@WebFilter(filterName = "testFilter1", urlPatterns = "/*")
public class OptionFilter implements Filter {
@Override
public void init(FilterConfig filterConfig) throws ServletException {

}
//@Bean
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
HttpServletResponse response = (HttpServletResponse) servletResponse;
String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
response.setHeader("Access-Control-Max-Age", "3600");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
response.setHeader("Access-Control-Allow-Credentials","true");
filterChain.doFilter(servletRequest, servletResponse);
}

@Override
public void destroy() {

}
}