package com.rental.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rental.bin.Houses;

public class HomeDB {
	Database db = new Database();
	Connection con = db.getCon();
	String s[][] = new String[100][10];
	String g[] = {"Id","residental_detail", "address", "bhk", "floor", "available_after", "payment_option", "availability","price", "user"};
	public String[][] getData() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			for(int i=0;rs.next();i++) {
				for(int j =0;j<10;j++) {
					s[i][j] = rs.getString(g[j]);
				}
			}
			//g = rs.getString(2);
			//System.out.println(s+"Hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[][] getFilteredBHKData(String bhk) {
		int k=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			while(rs.next()) {
				if(rs.getString("bhk").equals(bhk)) {
					for(int j =0;j<10;j++) {
						s[k][j] = rs.getString(g[j]);
					}
					k++;
				}
			}
			//g = rs.getString(2);
			//System.out.println(s+"Hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[][] getFilteredPaymentData(String payment) {
		int k=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			while(rs.next()) {
				if(rs.getString("payment_option").equals(payment)) {
					for(int j =0;j<10;j++) {
						s[k][j] = rs.getString(g[j]);
					}
					k++;
				}
			}
			//g = rs.getString(2);
			//System.out.println(s+"Hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[][] getFilteredTypeData(String type) {
		int k=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			while(rs.next()) {
				if(rs.getString("residental_detail").equals(type)) {
					for(int j =0;j<10;j++) {
						s[k][j] = rs.getString(g[j]);
					}
					k++;
				}
			}
			//g = rs.getString(2);
			//System.out.println(s+"Hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] getIdData(String id) {
		String[] O = new String[10];
		int k=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {
					for(int j =0;j<10;j++) {
						O[j] = rs.getString(g[j]);
					}
					k++;
				}
			}
			//g = rs.getString(2);
			//System.out.println(s+"Hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return O;
	}
	
	public String[] getUserData(String id,String user) {
		String O[] = new String[3];
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM houses");
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {
					O[2] = rs.getString("contact_no");
					O[0] = rs.getString("user");
				}
			}
			
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM users");
			
			while(rs1.next()) {
				if(rs1.getString("Name").equals(user)) {
					O[1] = rs1.getString("Id");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return O;
	}
	
}