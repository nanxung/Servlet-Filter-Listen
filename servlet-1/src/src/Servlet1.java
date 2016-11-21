package src;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cb on 16-11-16.
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    //处理Http POST请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str="在Servlet1中存放请求域信息";
        request.setAttribute("string",str);
        //获取请求分派器
        RequestDispatcher dispatcher=request.getRequestDispatcher("Servlet2");
        //将请求转发到指定路径的资源
        dispatcher.forward(request,response);
        //response.sendRedirect("Servlet2");//重定向到Servlet2
    }
    //处理Http GET请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //调用dpPost方法
        doPost(request,response);
    }
}
