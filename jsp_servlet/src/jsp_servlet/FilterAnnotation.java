package jsp_servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Created by cb on 16-11-21.
 */
@WebFilter(servletNames = {"jsp_servlet"},filterName = "characterFilter",
        initParams = {@WebInitParam(name="encoding",value="UTF-8")})
public class FilterAnnotation implements Filter {
    private FilterConfig config;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取Filter的初始参数值
        String encoding=config.getInitParameter("encoding");
        //输出获取到的编码值
        System.out.println(encoding);
        //设置请求数据的编码方式
        servletRequest.setCharacterEncoding(encoding);
        //把请求和请求对象传给过滤链的下一个要调用的过滤器或Servlet
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config=filterConfig;
    }

    @Override
    public void destroy(){

    }
}
