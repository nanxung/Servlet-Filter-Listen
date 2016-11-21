package src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cb on 16-11-16.
 */
@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println(" <head><title>servlet2</title></head>");
        out.println(" <body>");
        out.print("在servlet2获取请求参数name的值：");
        out.print(request.getParameter("name"));
        //获取名为"string"的请求域属性的值
        String str=(String) request.getAttribute("string");
        out.print("Servlet2中："+str);
        out.println("   </body>");
        out.println("   </html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
