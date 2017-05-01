import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by УВД on 30.04.2017.
 */

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String login=request.getParameter("login");
String password=request.getParameter("password");
if(login.equals("asd") && password.equals("123")){
    HttpSession session=request.getSession();
    session.setAttribute("forward","forward");
    session.setMaxInactiveInterval(1*60);
    Cookie cookie=new Cookie("login",login);
    cookie.setMaxAge(1*60);
    response.addCookie(cookie);
    response.sendRedirect("employee.jsp");
}else {
    RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
    PrintWriter printWriter=response.getWriter();
    printWriter.println("<font color=red>wrong login or password</font>");
    requestDispatcher.include(request,response);
}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
