package oop.com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



import oop.com.model.Product;

public interface ProductService {

	boolean addNewProduct(Product p)throws SQLException ;
	public ArrayList<Product> getAllProducts()throws SQLException;
	boolean deleteProduct(String firstname)throws SQLException ;
	
	 
}
