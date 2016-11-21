package Servlet过滤器;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by cb on 16-11-19.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding = config.getInitParameter("encoding");
        if(null!=encoding && !"".equals(encoding)){
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
                this.config=config;
    }

}
