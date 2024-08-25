package oop.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oop.com.model.Customer;
import oop.com.util.DBConnection;



public class CustomerDAO {
	


	
		public static int register(Customer c ,String sql) {
			int i=0;
			
				Connection con = DBConnection.getConnection();
				
				try {
					PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
					ps.setInt(1, c.getCid());
					ps.setString(2, c.getFname());
					ps.setString(3, c.getLname());
					ps.setString(4, c.getUname());
					ps.setString(5, c.getTelephone());
					ps.setString(6, c.getEmail());
					
					ps.setString(7, c.getPassword());

					i = ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				
				return i;
	}

	public static ResultSet login(Customer c ,String sql) {
			
			ResultSet rs = null;
			Connection con = DBConnection.getConnection();
			
			try {
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, c.getUname());
				ps.setString(2, c.getPassword());

				rs = ps.executeQuery();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return rs;
			
		}

		public static int update(Customer c, String sql) {
			// TODO Auto-generated method stub
			
			int j=0;
					Connection con = DBConnection.getConnection();
					
					//System.out.println("update dao eke inne");
					
					try {
						PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
						
						ps.setString(1, c.getFname());
						ps.setString(2, c.getLname());	
						ps.setString(3, c.getTelephone());
						ps.setString(4, c.getEmail());
						ps.setString(5, c.getPassword());
						ps.setString(6, c.getUname());
					
						
						
						j = ps.executeUpdate();
							
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					return j;
					
					
			}

		public static int update_value(Customer c, String sql2) {
			
			
			int i=0;
			
			Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql2);
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getTelephone());


			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return i;



		}
		
		
		public static int delete(Customer c,String sql) {
		
			int j=0;
			
			Connection con = DBConnection.getConnection();
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, c.getUname());
				
				j = ps.executeUpdate();
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return j;
			
			}
			
		
			
		
	}

