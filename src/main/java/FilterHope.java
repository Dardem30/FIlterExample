import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by УВД on 30.04.2017.
 */
public class FilterHope implements Filter {
    private ServletContext context;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpServletRequest request= (HttpServletRequest) req;
        HttpSession session=request.getSession(false);
        String uri=request.getRequestURI();
        if(session==null && uri.endsWith("jsp")){
            response.sendRedirect("index.html");
        }else {
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
this.context=config.getServletContext();
    }

}
