package oop.com.servlet;

	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import oop.com.model.Customer;
	import oop.com.service.CustomerDAO;
	
	/**
	 * Servlet implementation class DeleteUser
	 */
	@WebServlet("/DeleteUser")
	public class DeleteUser extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			String uname = request.getParameter("uname");
			
			Customer c = new Customer();
			
			c.setUname(uname);
			
			String sql = "delete from user where uname=?";
			
			int j = CustomerDAO.delete(c, sql);
			
			if(j !=0) {
			
				request.setAttribute("msg", "User Deleted");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			else {
				
				request.setAttribute("msg", "User not Deleted");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
		}

	}
	


