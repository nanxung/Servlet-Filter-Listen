package src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

/**
 * Created by cb on 16-11-16.
 */
@WebServlet(name = "Cookie-Servlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("username","cb");
        cookie.setMaxAge(24*3600);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        response.addCookie(cookie);
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            out.println("<h3>还没有Cookie</h3>");
        }
        else{
            out.println("<h3>COOKIE列表</h3>");
            for(Cookie c:cookies){
                out.println("Cookie名称："+c.getName());
                out.println(",对象的值："+c.getValue());
                out.println("<br/>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
