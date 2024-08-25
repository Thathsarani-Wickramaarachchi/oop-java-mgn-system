package oop.com.servlet;



	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import java.sql.ResultSet;

	import javax.servlet.http.Cookie;

	import javax.servlet.http.HttpSession;

	import oop.com.model.Customer;
	import oop.com.service.CustomerDAO;
	/**
	 * Servlet implementation class login
	 */
	@WebServlet("/login")
	public class login extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	   
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			

			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			
			
			if(uname.equals(null)||uname==""||password.equals(null)||password=="") {
				
				request.setAttribute("error", "error");
				getServletContext().getRequestDispatcher("").forward(request, response);
				System.out.println("gahala nee");
			}
			
			else {
			Customer u = new Customer();
			
			
			u.setUname(uname);
			u.setPassword(password);
			
			
			String sql = "select * from user where uname=? and password=?";
		
			
			ResultSet rs = CustomerDAO.login(u,sql);

			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60);
			System.out.println(u.getUname());
			Cookie userName = new Cookie("user", u.getUname());
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			
			try {
				if(rs.next()) {
					
					
					//session.setAttribute("cid", rs.getInt(1));
					session.setAttribute("fname", rs.getString(2));
					session.setAttribute("lname", rs.getString(3));
					session.setAttribute("uname", rs.getString(4));
					session.setAttribute("email", rs.getString(5));
					session.setAttribute("telephone", rs.getString(6));
					session.setAttribute("password", rs.getString(7));
					
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				
				}
				
				else{
					
					request.getRequestDispatcher("login.jsp").forward(request, response);
			
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		}
		
		
	}

