package oop.com.servlet;



	

	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	/**
	 * Servlet implementation class Logout
	 */
	@WebServlet("/Logout")
	public class Logout extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			
			response.setContentType("text/html");
	    	Cookie[] cookies = request.getCookies();
	    	if(cookies != null){
	    	for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("JSESSIONID")){
	    			System.out.println("JSESSIONID="+cookie.getValue());
	    			break;
	    		}
	    	}
	    	}
	    	
	    	
	    	HttpSession session = request.getSession(false);
	    	System.out.println("User="+session.getAttribute("user"));
	    	if(session != null){
	    		session.invalidate();
	    	}
	    	
	    	response.sendRedirect("index.jsp");
		}
	}
