package oop.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
//import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Statement;
//import com.mysql.jdbc.ResultSet;


import oop.com.model.Product;
import oop.com.service.ProductService;
import oop.com.util.DBConnection;

public class ProductServiceImpl implements ProductService {

	private static Connection conn;
	
	public ProductServiceImpl(){
		conn= DBConnection.getConnection();
	}
	@Override
	public boolean addNewProduct(Product p)throws SQLException {
	String sql="Insert into info values(?,?,?,?,?,?,?,?,?)";
	
	PreparedStatement ptm=conn.prepareStatement(sql);
	ptm.setObject(1,0);
	ptm.setObject(2,p.getFirstname());
	ptm.setObject(3,p.getEmail());
	ptm.setObject(4,p.getAddress());
	ptm.setObject(5,p.getState());
	ptm.setObject(6,p.getCity());
	ptm.setObject(7,p.getZip());
	ptm.setObject(8,p.getCardname());
	ptm.setObject(9,p.getCardnumber());
	
	int res=ptm.executeUpdate();
	
	return res>0;
	}
	@Override
	public ArrayList<Product> getAllProducts()throws SQLException{
		String sql="Select * from info";
		Statement ptm =conn.createStatement();
		ResultSet rst= ptm.executeQuery(sql);
		ArrayList<Product> pList =new ArrayList<Product>();
		
		while(rst.next()){ 
			Product p=new Product();
			p.setFirstname(rst.getString("firstname"));
			p.setEmail(rst.getString("email"));
			p.setAddress(rst.getString("address"));
			p.setState(rst.getString("state"));
			p.setCity(rst.getString("city"));
			p.setZip(rst.getString("zip"));
			p.setCardname(rst.getString("cardname"));
			p.setCardnumber(rst.getString("cardnumber"));
		
		pList.add(p);
		}
		
		return pList;
	}
	@Override
	public boolean deleteProduct(String firstname) throws SQLException {
		String sql="Delete from info where firstname='"+firstname+"'";
		Statement ptm =conn.createStatement();
		return ptm.executeUpdate(sql)>0;
		}
	
}
