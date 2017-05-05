package com.atemcs.techtalks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FetchData {
	
	
	public static boolean DeleteRequestedTalks(int id)
	{
		boolean result = false;
		int del = 0;
		Connection con = SqlConnect.getSqlConnection();
		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM `techtonics`.`requests` WHERE `requestid`=?");
			ps.setInt(1, id);
			del = ps.executeUpdate();
			if(del > 0)
			{
				return true;
			}
			else
			{
				return false; //deletion problem
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static int ApproveRequestedTalks(int id)
	{
		Connection con = SqlConnect.getSqlConnection();
		int result = 0;
		int del = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM techtonics.requests where requestid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			techtalks t = new techtalks();
			while(rs.next())
			{
				t.setPresenteeName(rs.getString("presentee"));
				t.setTopic(rs.getString("topic"));
				t.setLocation(rs.getString("location"));
				t.setWhen(rs.getString("when"));
			}
			PreparedStatement ps1 = con.prepareStatement("INSERT INTO `techtonics`.`techtalks` (`presenteeName`, `topic`, `location`, `when`) VALUES (?, ?, ?, ?)");
			ps1.setString(1, t.getPresenteeName());
			ps1.setString(2, t.getTopic());
			ps1.setString(3, t.getLocation());
			ps1.setString(4, t.getWhen());
			result = ps1.executeUpdate();
			if(result > 0)
			{
				PreparedStatement ps2 = con.prepareStatement("DELETE FROM `techtonics`.`requests` WHERE `requestid`=?");
				ps2.setInt(1, id);
				del = ps2.executeUpdate();
				if(del > 0)
				{
					return 1;
				}
				else
				{
					return 2; //deletion problem
				}
				
			}
			else
			{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean userExists(int empid)
	{
		boolean valid=true;
		Connection con = SqlConnect.getSqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT empid FROM techtonics.users where empid=?");
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				valid = false;
			}
			return valid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
	
	public static int Signup(int empid,String name,String password,String email)
	{
		Connection con = SqlConnect.getSqlConnection();
		if(userExists(empid))
		{
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO `techtonics`.`users` (`empid`, `name`, `password`, `email`, `isAdmin`) VALUES (?, ?, ?, ?, 'no')");
				ps.setInt(1, empid);
				ps.setString(2, name);
				ps.setString(3, password);
				ps.setString(4, email);
				int update = ps.executeUpdate();
				if(update>0)
				{
					return 1;
				}
				else
				{
					return 0;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			return 3;
		}
			
		return 0;
		
	}
	
	
	
	public static ArrayList<techtalks> FetchRequestedTalks()
	{
		ArrayList<techtalks> list  = new ArrayList<>();
		Connection con = SqlConnect.getSqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM techtonics.requests");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new techtalks(rs.getInt("requestid"),rs.getString("presentee"),rs.getString("topic"),rs.getString("location"),rs.getString("when")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static int UpdateTech(int id,String presenteename,String topic,String location,String when){
		
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Connection con = SqlConnect.getSqlConnection();
		try {
			//Date date = (Date) format.parse(when);
			PreparedStatement ps = con.prepareStatement("UPDATE `techtonics`.`techtalks` SET `presenteeName`=?, `topic`=?, `location`=?, `when`=? WHERE `techtalksid`=?");
			ps.setString(1, presenteename);
			ps.setString(2, topic);
			ps.setString(3, location);
			ps.setString(4, when);
			ps.setInt(5, id);
			int update = ps.executeUpdate();
			if(update>0)
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}
	
	public static ArrayList<techtalks> fetchUpdate(int id){
		
		Connection con = SqlConnect.getSqlConnection();
		ArrayList<techtalks> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM techtonics.techtalks where techtalksid=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();
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
	
	public static int deleteTalk(int id){
		
		Connection con = SqlConnect.getSqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("DELETE FROM `techtonics`.`techtalks` WHERE `techtalksid`=?");
			ps.setInt(1, id);
			int del =  ps.executeUpdate();
			if(del > 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
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
