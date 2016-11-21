package FirstServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cb on 16-11-15.
 */
public class FirstServlet extends HttpServlet {
    //处理GET请求

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doGet方法
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");
        //从相应对象中获取打印流
        PrintWriter out=resp.getWriter();
        //写字符串
        out.println("这是我的第一个Servlet应用");
        super.doPost(req, resp);
    }
//销毁Servlet
    @Override
    public void destroy() {

        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
