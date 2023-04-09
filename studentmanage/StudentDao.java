package com.studentmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertToDb(Student st) {
		
		boolean f = false;
		try {
			
			
			Connection con = CP.createC();
			
			String q = "insert into studentdetails(sname,sphone,scity) values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, st.getSname());
			pstmt.setString(2, st.getSphone());
			pstmt.setString(3, st.getScity());
			
			pstmt.executeUpdate();
			f =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteById(int uid) {

		boolean f = false;
		try {
			
			
			Connection con = CP.createC();
			
			String q = "delete from studentdetails where sid=?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, uid);
			
			
			pstmt.executeUpdate();
			f =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		
		
		try {
			
			
			Connection con = CP.createC();
			
			String q = "select * from studentdetails";
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID :"+id);
				System.out.println("NAME :"+name);
				System.out.println("PHONE :"+phone);
				System.out.println("city :"+city);
				
				System.out.println("++++++++++++++++++++++++++");
				
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static void showById(int uid) {

		// TODO Auto-generated method stub
		try {
		Connection con = CP.createC();
        String q = "select * from studentdetails where sid = ?";
        PreparedStatement pstmt = con.prepareStatement(q);
        pstmt.setInt(1, uid);
        ResultSet set = pstmt.executeQuery();

        if (!set.next()) {
            System.out.println("No data found for ID "+uid);
            return;
        }

        int id = set.getInt("sid");
        String name = set.getString("sname");
        String phone = set.getString("sphone");
        String city = set.getString("scity");

        System.out.println("ID :"+id);
        System.out.println("NAME :"+name);
        System.out.println("PHONE :"+phone);
        System.out.println("city :"+city);

    } catch (Exception e) {
        e.printStackTrace();
    }
		
		
	}
   
	public static void updateById(int uid, String name, String phone, String city) {
	    try {
	        Connection con = CP.createC();
	        String q = "update studentdetails set sname=?, sphone=?, scity=? where sid=?";
	        PreparedStatement pstmt = con.prepareStatement(q);
	        pstmt.setString(1, name);
	        pstmt.setString(2, phone);
	        pstmt.setString(3, city);
	        pstmt.setInt(4, uid);
	        int rowsUpdated = pstmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Record updated successfully.");
	        } else {
	            System.out.println("No records found for ID "+uid);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
