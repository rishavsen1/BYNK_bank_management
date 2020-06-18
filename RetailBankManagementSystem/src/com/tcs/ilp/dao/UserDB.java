package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDB {
	public static final String DB_NAME = "users.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Srijit\\" + DB_NAME;
	public static final String TABLE_NAME = "userinfo";
	public static final String COLUMN_USER_NAME = "uname";
	public static final String COLUMN_USER_PASS = "upass";
	public static final String QUERY = "SELECT * FROM " + TABLE_NAME
										+ " WHERE " + COLUMN_USER_NAME + " = ? AND " 
										+ COLUMN_USER_PASS + " = ? "; 
	
	public static boolean getUser(String uname,String upass){
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(QUERY);
			 statement.setString(1,uname);
			 statement.setString(2,upass);
			
			 resultSet = statement.executeQuery();
			 
			 if(resultSet.next()) {
				 return true;
			 }
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static String getUserDomain(String uname,String upass){
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(QUERY);
			 statement.setString(1,uname);
			 statement.setString(2,upass);
			
			 resultSet = statement.executeQuery();
			 
			 if(resultSet.next()) {
				 return resultSet.getString(4);
			 }
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
