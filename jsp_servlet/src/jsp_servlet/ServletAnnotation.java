package jsp_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cb on 16-11-21.
 */
@WebServlet(name="ServletAnnotation",urlPatterns={"/*"},
description = "servletinfo",displayName = "abc",asyncSupported = true,
        initParams = {@WebInitParam(name="username",value="SunLianwei")}
)
public class ServletAnnotation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig cfg的实例
        ServletConfig cfg=this.getServletConfig();
        //获取指定参数名称的值
        String name=cfg.getInitParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("   <head><title>Servlet应用实例</title></head>");
        out.println("   <body>");
        out.println("获取InitParamServlet的初始化参数\"username\"的字符串值:");
        out.print(name);
        out.print(" </body>");
        out.println("</html>");
    }
}
