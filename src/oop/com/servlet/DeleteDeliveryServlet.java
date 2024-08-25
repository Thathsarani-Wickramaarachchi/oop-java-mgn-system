package oop.com.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.com.service.DeliverySeriviceImpl;

import oop.com.service.DeliveryService;

/**
 * Servlet implementation class DeleteDeliveryServlet
 */
@WebServlet("/DeleteDeliveryServlet")
public class DeleteDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeliveryServlet() {
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
		
		String nicNum= request.getParameter("deleteValue");
		
		DeliveryService ds=new DeliverySeriviceImpl();
		
		boolean isDeleted=false; 
		try {
			isDeleted =ds.deleteDelivery(nicNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		if(isDeleted==true) {
			PrintWriter writer =response.getWriter();
			writer.println("<script>");
			writer.println("alert('Delivery Order Deleted Successfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/deliOrder.jsp");
			dispatcher.include(request, response);
		}
	}

}

