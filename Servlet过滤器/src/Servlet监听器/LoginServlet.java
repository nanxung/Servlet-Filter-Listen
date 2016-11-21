package Servlet监听器;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by cb on 16-11-20.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
                String username=request.getParameter("username");
        //往session中添加属性
        //会触发HttpSessionAttributeListener中的attributeAdded方法
        if(username!=null&&!username.equals("")){
            request.getSession().setAttribute("username",username);
        }
        //从应用上下文中获取在线用户名列表
        List<String>online=(List<String>)getServletContext().getAttribute("online");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>用户列表</TITLE></HEAD>");
        out.println("   <BODY>");
        out.println("当前用户是："+username);
        out.print("     <hr/><h3>在线用户列表</h3>");
        int size=online==null?0:online.size();
        for(int i=0;i<size;i++){
            if(i>0){
                out.println("<br/>");

            }
            out.println(i+1+"."+online.get(i));
        }
        //注意：要对链接URL进行自动重写处理
        out.println("<hr/><a href=\""+response.encodeURL("logout")+"\">注销</a>");
        out.println("   </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doPost(request,response);
    }
}
