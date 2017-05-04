package com.atemcs.techtalks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FetchData {
	
	
	public static String getUserName(String email){
		
		Connection con = SqlConnect.getSqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select name from users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			String name = null;
			while(rs.next())
			{
				name = rs.getString("name");
			}
			return name;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
