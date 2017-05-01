import by.DAO.DAOImple;
import by.model.EmployeeEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        DAOImple daoImple=new DAOImple();
        if(request.getParameter("add")!=null){
            EmployeeEntity employeeEntity=new EmployeeEntity();
            employeeEntity.setEmployeeId(Long.parseLong(request.getParameter("employeeId")));
            employeeEntity.setFirstname(request.getParameter("firstname"));
            employeeEntity.setLastname(request.getParameter("lastname"));
            daoImple.saveEmployee(employeeEntity);
        }
        if(request.getParameter("showAll")!=null){
            request.setAttribute("list",daoImple.getList());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("showAll.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
