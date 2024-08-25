package oop.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.com.model.Product;
import oop.com.service.ProductService;
import oop.com.service.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname =request.getParameter("firstname");
		String email =request.getParameter("email");
		String address =request.getParameter("address");
		String city =request.getParameter("city");
		String state =request.getParameter("state");
		String zip =request.getParameter("zip");
		String cardname =request.getParameter("cardname");
		String cardnumber =request.getParameter("cardnumber");
		
		Product p=new Product();
		
		p.setFirstname(firstname);
		p.setEmail(email);
		p.setAddress(address);
		p.setCity(city);
		p.setState(state);
		p.setZip(zip);
		p.setCardname(cardname);
		p.setCardnumber(cardnumber);
		
		ProductService pService= new ProductServiceImpl();
		
		try {
			boolean isAdded =pService.addNewProduct(p);
			if(isAdded==true){
				System.out.println("sucess");
				PrintWriter writer= response.getWriter();
				
				writer.println("<script>");
				writer.println("alert('Added Successfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/paysucessmsg.jsp");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
