package com.atemcs.techtalks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestTalk {
	
	static int makeRequest(int empid,String empname,String topic,String location){
		
		Connection con = SqlConnect.getSqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO `techtonics`.`requests` (`presentee`, `topic`, `location`, `empid`) VALUES (?, ?, ?, ?)");
			ps.setString(1, empname);
			ps.setString(2, topic);
			ps.setString(3, location);
			ps.setInt(4, empid);
			int request = ps.executeUpdate();
			if(request > 0)
			{
				return 1;
			}
			else
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}

}
