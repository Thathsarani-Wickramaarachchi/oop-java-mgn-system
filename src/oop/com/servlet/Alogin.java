package oop.com.servlet;


	

	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	
	/**
	 * Servlet implementation class Alogin
	 */
	@WebServlet("/Alogin")
	public class Alogin extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	  
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			String uname= request.getParameter("uname");
			String password = request.getParameter("password");
			
			
			String u = "admin";
			String p = "admin";
			/*
				if(uname.equals(null)||uname==""||password.equals(null)||password=="") {
				
				request.setAttribute("error", "error");
				getServletContext().getRequestDispatcher("Alogin.jsp").forward(request, response);
				//System.out.println("gahala nee");
			}
			
			*/
				
				if(uname.equals(u) && password.equals(p)) {
					
					request.getRequestDispatcher("addItem.jsp").forward(request, response);
					
				}
				
				
				else {
					
					request.getRequestDispatcher("ALogin.jsp").forward(request, response);
				}
				
			
		}

	}



