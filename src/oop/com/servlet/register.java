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
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

		int j =0;
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String conpassword = request.getParameter("conpassword");
		
		if(fname.equals(null)||fname==""||lname.equals(null)||lname==""||uname.equals(null)||uname==""||email.equals(null)||email==""||telephone.equals(null)||telephone=="") {
		
			request.setAttribute("ferror", "Please fill the all fields");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
			
		}
		
		else {
		
			if(!password.equals(conpassword)) {
				
				request.setAttribute("perror", "Password not matching");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}
			
			else {
		Customer c = new Customer();
		
		c.setFname(fname);
		c.setLname(lname);		
		c.setUname(uname);
		c.setEmail(email);
		c.setTelephone(telephone);
		c.setPassword(password);
		
		System.out.println(fname);
		
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		j = CustomerDAO.register(c,sql);
		
		if(j != 0) {
			request.setAttribute("msg", "Register sucessfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		else {
			
			request.getRequestDispatcher("register.jsp").forward(request, response);
	
			
		}
		
	}
	}
	}
}

