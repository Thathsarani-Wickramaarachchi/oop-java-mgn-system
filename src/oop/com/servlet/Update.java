package oop.com.servlet;





	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import oop.com.model.Customer;
	import oop.com.service.CustomerDAO;

	/**
	 * Servlet implementation class Update
	 */
	@WebServlet("/Update")
	public class Update extends HttpServlet {
		private static final long serialVersionUID = 1L;
	     
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//doGet(request, response);
			
			HttpSession session = request.getSession();
			
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String password = request.getParameter("password");
			
			Customer c = new Customer();
			
			c.setFname(fname);
			c.setLname(lname);
			c.setUname(uname);
			c.setEmail(email);
			c.setTelephone(telephone);
			c.setPassword(password);
			
		
			
			String sql = "update user set fname=?,lname=?,telephone=?,email=?,password=? where uname=?";
			
			int j= CustomerDAO.update(c,sql);
			
			
			
			if(j!= 0) {
				
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("uname", uname);
				session.setAttribute("email", email);
				session.setAttribute("telephone", telephone);
				session.setAttribute("password", password);
				
				request.setAttribute("msg", "update sucessfuly");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				
				
				
			}
			
			else {
				request.setAttribute("msg", "update not sucessfuly");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
				
			}
		}


	}

