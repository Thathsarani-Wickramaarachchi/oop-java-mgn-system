package oop.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oop.com.model.Item;
import oop.com.util.DBConnection;


public class ItemService implements IItemService {
	
	private static Connection conn;
	
	public ItemService() {
		
		conn = DBConnection.getConnection();
	}
	

	
	@Override
	public boolean addItem(Item item) throws SQLException {
		
		String sql = "Insert into item values (?, ?, ?, ?, ?)";
		
		PreparedStatement stm = conn.prepareStatement(sql);
		
			stm.setObject(1,0);
			stm.setObject(2, item.getCode());
			stm.setObject(3, item.getName());
			stm.setObject(4, item.getCategory());
			stm.setObject(5, item.getPrice());
			
			int res = stm.executeUpdate();
		
		return res>0;
	}
	


	@Override
	public ArrayList<Item> getAllItems() throws SQLException {
		
		String sql = "Select * from item ";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Item> iList = new ArrayList<Item>();
		
		while(rst.next()) {
		
		Item item = new Item();
		item.setCode( rst.getString ("iCode") );
		item.setName( rst.getString("iName") );
		item.setCategory( rst.getString("iCategory") );
		item.setPrice(rst.getString("iPrice") );
		
		iList.add(item);
		
		}
		
		return iList;	
	}



	@Override
	public boolean deleteItem(String code) throws SQLException {
		
		String sql = "Delete from item where iCode = '"+code+"'";
		Statement stm = conn.createStatement();
		
		
		return stm.executeUpdate(sql)>0;
	}



	/*@Override
	public void editItem(int iId, Item item) throws SQLException {
		
		String sql = "update item set iCode = ?, iName = ?, iCategory = ?, iPrice = ? ";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setString(2, item.getCode());
		stm.setString(3, item.getName());
		stm.setString(4, item.getCategory());
		stm.setString(5, item.getPrice());
		
		stm.execute();
			
		
	}*/

}
