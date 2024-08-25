package oop.com.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oop.com.model.deliveryReq;
import oop.com.service.DeliveryService;
import oop.com.util.DBConnection;

public class DeliverySeriviceImpl implements DeliveryService{

	private static Connection conn;
	
	public DeliverySeriviceImpl() {
		conn=DBConnection.getConnection();
		
		
		
	}
	 
	@Override
	public boolean addNewDeliveryReq(deliveryReq dr1) throws SQLException {
		
		String sql="Insert into DeliveryReq values (?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setObject(1, dr1.getNicnum());
		pst.setObject(2, dr1.getAddress());
		pst.setObject(3, dr1.getContactNo());
		pst.setObject(4, dr1.getEmail());
		pst.setObject(5, dr1.getDldate());
		
		int res=pst.executeUpdate();
		return res>0;
		
	}

	@Override
	public ArrayList<deliveryReq> getAllDelivery() throws SQLException {
		String sql="Select * from deliveryreq";
		Statement stm = conn.createStatement();
		ResultSet rst=stm.executeQuery(sql);
		ArrayList<deliveryReq> dls =new ArrayList<deliveryReq>();
		
		while(rst.next()) {
			deliveryReq dr1=new deliveryReq();
			
			dr1.setNicnum(rst.getString("cnic"));
			dr1.setAddress(rst.getString("caddress"));
			dr1.setContactNo(rst.getString("cnumber"));
			dr1.setEmail(rst.getString("cemail"));
			dr1.setDldate(rst.getString("dldate"));
				
			
			dls.add((deliveryReq) dr1);
			 
		}
		
		return dls;
				
				
				
			
			
		
		
	}

	@Override
	public boolean deleteDelivery(String nicNum) throws SQLException {
		String sql="Delete from deliveryreq where cnic='"+nicNum+"'";
		Statement stm=conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	
	
}

	

