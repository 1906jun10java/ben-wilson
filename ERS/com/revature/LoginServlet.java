package com.revature.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.beans.Employees;
import com.revature.beans.Login;
import com.revature.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService ls = new LoginService();
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login log = new Login(request.getParameter("username"), request.getParameter("password"));
		Employees e = ls.checkLogin(log);
	
		if (e != null) {
			
			session.setAttribute("userId", e.getId());
			session.setAttribute("problem", null);
			
			if(ls.isManager(e.getId())) {
				response.sendRedirect("manager"); 
			}else {
				
				response.sendRedirect("employee");
			}
		}else {
			
			response.sendRedirect("login");
		}
	}
}
