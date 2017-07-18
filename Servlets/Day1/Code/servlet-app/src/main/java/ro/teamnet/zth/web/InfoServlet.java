package ro.teamnet.zth.web;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Cristina.Constantin on 7/18/2017.
 */
@MultipartConfig
public class InfoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pr = response.getWriter();

        response.setContentType("text/html");

        Enumeration<String> enumerations = request.getParameterNames();
        while(enumerations.hasMoreElements()){
            String parametersName = enumerations.nextElement();
            pr.write("Header name " + parametersName);
            Enumeration<String> headers = request.getHeaders(parametersName);

            while(headers.hasMoreElements()){
                String headerValue = headers.nextElement();
                pr.write("\n" + headerValue);
                pr.write("\n");
            }
        }

        pr.write("Method" + request.getMethod() + "\n");
    }
}
