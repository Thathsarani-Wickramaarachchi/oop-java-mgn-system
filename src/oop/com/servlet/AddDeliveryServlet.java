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

import oop.com.service.DeliverySeriviceImpl;

import oop.com.model.deliveryReq;
import oop.com.service.DeliveryService;

/**
 * Servlet implementation class AddDeliveryServlet
 */
@WebServlet("/AddDeliveryServlet")
public class AddDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nicnum=request.getParameter("nicnum");
		String address=request.getParameter("address");
		String contactNo=request.getParameter("number");
		String email=request.getParameter("email");
		String  dldate=request.getParameter("dldate");
		
		deliveryReq dr1=new deliveryReq();
		
		dr1.setNicnum(nicnum);
		dr1.setAddress(address);
		dr1.setContactNo(contactNo);
		dr1.setEmail(email);
		dr1.setDldate(dldate);
		
		DeliveryService ds=new DeliverySeriviceImpl();
		
		try {
			boolean isAdded= ds.addNewDeliveryReq(dr1);
			
			if(isAdded==true) {
				System.out.println("Success");
				
				PrintWriter writer =response.getWriter();
				writer.println("<script>");
				writer.println("alert('Delivery Request Added Successfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/deliverysuccess.jsp");
				dispatcher.include(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
