package com.revature.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.service.LoginService;

@WebServlet("/Manager")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService ls = new LoginService();
    public ManagerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		
		if(ls.isManager(userId)) {
			request.getRequestDispatcher("Managers.html").forward(request, response);
		}else {
			response.sendRedirect("employee");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
