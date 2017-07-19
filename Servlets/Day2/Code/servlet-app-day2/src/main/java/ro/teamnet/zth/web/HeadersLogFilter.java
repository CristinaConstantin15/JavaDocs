package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Cristina.Constantin on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy(){

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws ServletException, IOException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Enumeration<String> headersNames = httpRequest.getHeaderNames();
        if(headersNames != null){
            while(headersNames.hasMoreElements()){
                LogFileWriter.logHeader(headersNames.nextElement(), httpRequest.getHeader(headersNames.nextElement()));
            }
        }

        filter.doFilter(httpRequest,httpResponse);
    }

    public void init(FilterConfig config) throws ServletException{

    }
}
