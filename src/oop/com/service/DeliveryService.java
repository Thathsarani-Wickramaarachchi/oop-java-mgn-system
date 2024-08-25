package oop.com.service;



import java.sql.SQLException;
import java.util.ArrayList;

import oop.com.model.deliveryReq;

public interface DeliveryService {

	boolean addNewDeliveryReq(deliveryReq dr1) throws SQLException;

	public ArrayList<deliveryReq> getAllDelivery() throws Exception;

	boolean deleteDelivery(String nicNum) throws SQLException;

	
	
	
}
