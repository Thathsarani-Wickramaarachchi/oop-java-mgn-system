package oop.com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import oop.com.model.Item;

public interface IItemService  {

	boolean addItem(Item item)throws SQLException ;
	
	public ArrayList<Item> getAllItems() throws SQLException;

	boolean deleteItem(String code) throws SQLException;

	//void editItem(int iId, Item item) throws SQLException;


}

