package com.atemcs.techtalks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class LoginValidation {

	static boolean validate(String email,String pwd,String priv){
		
		Connection con = SqlConnect.getSqlConnection();
		try {
			boolean valid=false;
			if(priv.equals("admin"))
			{
				PreparedStatement ps = con.prepareStatement("Select name from users where email=? and password=? and isAdmin=?");
				ps.setString(1, email);
				ps.setString(2, pwd);
				ps.setString(3, "yes");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					valid=true;
					
				}
			}
			else
			{
				PreparedStatement ps = con.prepareStatement("Select name from users where email=? and password=? and isAdmin=?");
				ps.setString(1, email);
				ps.setString(2, pwd);
				ps.setString(3, "no");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					valid=true;
					
				}
			}
			
			return valid;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
