package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cristina.Constantin on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "";
        String password = "";
        PrintWriter pr = response.getWriter();

        response.setContentType("text/html");

        user = request.getParameter("username");
        password = request.getParameter("password");
        Cookie[] cookies = request.getCookies();

        if(user.equals("admin") && password.equals("admin")){
            pr.write("Welcome back " +  user + "!");
            for(int i=0; i<cookies.length; ++i){
                pr.write("Cookie: " + cookies[i].getName() + " name " + cookies[i].getValue() + " value ");
            }
            pr.write("Your session id is " + request.getRequestedSessionId());
        }else{
            request.getSession().setAttribute("session", request.getSession());
            request.getSession().setAttribute("user", user);
           // RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginFail.jsp");
            //dispatcher.forward(request,response);
            response.sendRedirect("/views/loginFail.jsp");

        }

        // TODO Write the response content to the PrintWriter instance of the response instance
        // TIP: use write() method
        // TIP: you can also use html tags to markup your text


    }
}
