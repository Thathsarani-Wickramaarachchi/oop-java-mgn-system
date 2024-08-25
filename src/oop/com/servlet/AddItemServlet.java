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
import oop.com.model.Item;
import oop.com.service.IItemService;
import oop.com.service.ItemService;
/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String code = request.getParameter("code"); 
        String name = request.getParameter("name");
        String category = request.getParameter("cat");
        String price = request.getParameter("price");
       

        Item item = new Item();
        

        
        IItemService iserv = new ItemService(); 
        
        try {
            item.setCode(code);
            item.setName(name);
            item.setCategory(category);
            item.setPrice(price);
            
			boolean isAdded = iserv.addItem(item);
			
			if(isAdded == true ) {
				
				System.out.println("success!");
				PrintWriter writer = response.getWriter();
				writer.println("<script>");
				writer.println("alert ('Added Successfully!')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itemList.jsp");
				dispatcher.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
   
	}

}
