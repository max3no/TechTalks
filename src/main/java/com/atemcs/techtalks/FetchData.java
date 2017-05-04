package com.atemcs.techtalks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
	public static int getUserId(String email)
	{
		Connection con = SqlConnect.getSqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select empid from users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next())
			{
				id = rs.getInt("empid");
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<techtalks> getTalks(){
		
		Connection con = SqlConnect.getSqlConnection();
		try {
			ArrayList<techtalks> list = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("Select * from techtalks");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new techtalks(rs.getInt("techtalksid"),rs.getString("presenteeName"),rs.getString("topic"),rs.getString("location"),rs.getString("when")));
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static int attendTalk(int empid,int techtalkid)
	{
		Connection con = SqlConnect.getSqlConnection();
		try {
			if(checkAttendee(empid, techtalkid))
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO `techtonics`.`attendee` (`empid`, `techtalksid`) VALUES (?, ?)");
				ps.setInt(1, empid);
				ps.setInt(2, techtalkid);
				int attend = ps.executeUpdate();
				if(attend>0)
				{
					return 1;
				}
				else
				{
					return 2;
				}
			}
			else
			{
				return 3;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static boolean checkAttendee(int empid,int techtalkid)
	{
		Connection con = SqlConnect.getSqlConnection();
		boolean valid = true;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM attendee where empid=? and techtalksid=?");
			ps.setInt(1, empid);
			ps.setInt(2, techtalkid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				valid=false;
			}
			return valid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
