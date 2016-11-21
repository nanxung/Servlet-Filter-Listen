package Servlet监听器;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by cb on 16-11-19.
 */
@WebServlet(name = "OnlineListener")
public class Servlet2 implements ServletContextListener,HttpSessionAttributeListener,HttpSessionListener {
    private ServletContext application=null;
    public void attributeAdded(HttpSessionBindingEvent arg0){
        //取得用户列表
        List<String> online=(List<String>)this.application.getAttribute("online");
        if("username".equals(arg0.getName())){
            //将当前用户添加到列表
            online.add((String)arg0.getValue());
        }
        //将添加的列表重置到application属性中
        this.application.setAttribute("online",online);
    }
    //以下方法用空实现


    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }
    //会话销毁时回调的方法


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //取得用户名列表
        List<String>online=(List<String>)this.application.getAttribute("online");
        //取得当前用户名
        String username=(String)se.getSession().getAttribute("username");
        //将此用户名删除
        online.remove(username);
        //将删除后的列表重新设置到application中
        this.application.setAttribute("online",online);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    //应用上下文初始会回调的方法


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化一个application对象
        this.application=sce.getServletContext();
        //设置一个列表属性用于保存在线用户名
        this.application.setAttribute("online",new LinkedList<String>());
    }


}
