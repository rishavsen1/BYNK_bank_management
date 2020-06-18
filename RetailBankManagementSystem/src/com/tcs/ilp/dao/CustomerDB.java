package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.ilp.bean.CustomerBean;
import com.tcs.ilp.bean.TransactionBean;

public class CustomerDB {
	public static final String DB_NAME = "users.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Srijit\\" + DB_NAME;
	public static final String NAME = "customer";
	public static final String COLUMN_CUSTOMER_ID = "CustomerID";
	public static final String COLUMN_CUSTOMER_NAME = "CustomerName";
	public static final String COLUMN_CUSTOMER_AGE = "CustomerAge";
	public static final String COLUMN_CUSTOMER_ADDRESS = "CustomerAddress";
	public static final String COLUMN_CUSTOMER_CITY = "CustomerCity";
	public static final String COLUMN_CUSTOMER_STATE = "CustomerState";
	public static final String INITIAL_AMOUNT = "1000";
	
	public static final String TABLE_NAME = "Accounts";
	public static final String COLUMN_ACCOUNTS_ID = "CustomerId";
	public static final String COLUMN_ACCOUNTS_BALANCE = "acct_Balance";
	public static final String COLUMN_ACCOUNTS_TRANSACTION_DATE = "acct_lasttrdate";
	
	public static final String TABLE = "Transaction";
	public static final String COLUMN_ONE = "Source Customer ID";
	public static final String COLUMN_TWO = "Latest Balance(Source)";
	public static final String COLUMN_THREE = "Target Customer ID";
	public static final String COLUMN_FOUR = "Latest Balance(Target)";
	
	public static final String INSERT_QUERY = "INSERT INTO " + NAME + " (" + COLUMN_CUSTOMER_NAME +"," +
								COLUMN_CUSTOMER_AGE + "," + COLUMN_CUSTOMER_ADDRESS + "," + 
								COLUMN_CUSTOMER_CITY + "," + COLUMN_CUSTOMER_STATE + ")" + 
								"VALUES(?,?,?,?,?)";
	public static final String SELECT_QUERY = "SELECT * FROM " + NAME + " WHERE " +
								COLUMN_CUSTOMER_ID + " = ? ";
	
	public static final String DELETE_QUERY = "DELETE FROM " + NAME + " WHERE " + 
								COLUMN_CUSTOMER_ID + " = ? ";
	
	public static final String UPDATE_QUERY = "UPDATE " + NAME + " SET " + 
											  COLUMN_CUSTOMER_NAME + " = ? ," +
											  COLUMN_CUSTOMER_AGE + " = ? ," +
											  COLUMN_CUSTOMER_ADDRESS + " = ? ," +
											  COLUMN_CUSTOMER_CITY + " = ? ," +
											  COLUMN_CUSTOMER_STATE + " = ? WHERE " +
											  COLUMN_CUSTOMER_ID + " = ? ";
	
	public static final String UPDATE_ACCOUNT_QUERY = "UPDATE " + TABLE_NAME + 
														" SET " + 
														COLUMN_ACCOUNTS_BALANCE + " = ? ," +
														COLUMN_ACCOUNTS_TRANSACTION_DATE + " = datetime('now','localtime') " +
														" WHERE " + 
														COLUMN_ACCOUNTS_ID + " = ? ";
	
	public static final String TRANSACTION_QUERY = "INSERT INTO " + TABLE + " ( " +
													COLUMN_ONE + "," +
													COLUMN_TWO + "," +
													COLUMN_THREE + "," +
													COLUMN_FOUR + " )VALUES(?,?,?,?) ";
													
														
											  
	
	public static int addCustomer(String custName,int custAge,String custAddress,String custCity,String custState) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Statement statement1 = null;
		ResultSet resultSet1 = null;
		
		
		try {
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);
			 statement.setString(1,custName);
			 statement.setInt(2,custAge);
			 statement.setString(3,custAddress);
			 statement.setString(4,custCity);
			 statement.setString(5,custState);
			 
			 statement.executeUpdate();
			 
			 resultSet = statement.getGeneratedKeys();
			 if(resultSet.next()) {
				 int id = resultSet.getInt(1);
				 statement1 = conn.createStatement();
				 //System.out.print(LocalDate.now());
				 statement1.execute("INSERT INTO Accounts VALUES(" + id + "," + INITIAL_AMOUNT + 
						 		"," + "datetime('now','localtime')" + ")");
				 return id;
			 }else {
				 return 0;
			 }
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
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
				if(statement1 != null) {
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
	}
	
	public static List<CustomerBean> getCustomerInfo(int id){
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<CustomerBean> customer = null;
		
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(SELECT_QUERY);
			 statement.setInt(1,id);
			 
			 resultSet = statement.executeQuery();
			 
			 
			 while(resultSet.next()) {
				 CustomerBean cbean = new CustomerBean();
				 cbean.setId(id);
				 cbean.setCustName(resultSet.getString(2));
				 cbean.setCustAge(resultSet.getInt(3));
				 cbean.setCustAddress(resultSet.getString(4));
				 cbean.setCustCity(resultSet.getString(5));
				 cbean.setCustState(resultSet.getString(6));
				 customer = new ArrayList<>();
				 customer.add(cbean);
			 }
			 return customer;
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
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
	}
	
	public static boolean deleteCustomerInfo(int id) {
		
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;	
		PreparedStatement statement1 = null;	
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(DELETE_QUERY);
			 statement.setInt(1,id);
			 
			 statement1 = conn.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE " + 
					 							COLUMN_ACCOUNTS_ID + " = ? ");
			 statement1.setInt(1,id);
			 statement1.executeUpdate();
			 
			 
			 int affectedRows = statement.executeUpdate();
			 if(affectedRows == 1) {
				 return true;
			 }
			 return false;
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
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
	}
	
	public static boolean updateCustomerInfo(int custId,String custName,int custAge,String custAddress,String custCity,String custState) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;	
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(UPDATE_QUERY);
			 statement.setString(1,custName);
			 statement.setInt(2,custAge);
			 statement.setString(3,custAddress);
			 statement.setString(4,custCity);
			 statement.setString(5,custState);
			 statement.setInt(6, custId);
			 
			 int affectedRows = statement.executeUpdate();
			 if(affectedRows == 1) {
				 return true;
			 }
			 return false;
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
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
	}
	
	public static int updateAccounts(int id,int amount) {
		Connection conn = null;
		PreparedStatement statement = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;	
		Statement statement1 = null;
		ResultSet resultSet1 = null;
		
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(UPDATE_ACCOUNT_QUERY);
			 stmt = conn.prepareStatement("SELECT acct_Balance FROM " + TABLE_NAME + 
					 						" WHERE " + COLUMN_ACCOUNTS_ID + " = ?");
			 
			 stmt.setInt(1, id);
			 resultSet = stmt.executeQuery();
			 
			 amount += resultSet.getInt(1);
			 
			 statement.setInt(1,amount);
			 statement.setInt(2,id);
			 
			 
			 int affectedRows = statement.executeUpdate();
			 
			 if(affectedRows == 1) {
				 statement1 = conn.createStatement();
				 resultSet1 = statement1.executeQuery("SELECT acct_Balance FROM " + TABLE_NAME + 
						 							" WHERE " + COLUMN_ACCOUNTS_ID + " = " + id);
				 return resultSet1.getInt(1);
			 }
			  return 0;
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
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
	}
	
	public static int updateAccountsWithDraw(int id,int amount) {
		Connection conn = null;
		PreparedStatement statement = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;	
		Statement statement1 = null;
		ResultSet resultSet1 = null;
		
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 statement = conn.prepareStatement(UPDATE_ACCOUNT_QUERY);
			 stmt = conn.prepareStatement("SELECT acct_Balance FROM " + TABLE_NAME + 
					 						" WHERE " + COLUMN_ACCOUNTS_ID + " = ?");
			 
			 stmt.setInt(1, id);
			 resultSet = stmt.executeQuery();
			 
			 int previous_amount = resultSet.getInt(1);
			 
			 previous_amount -= amount;
			 
			 statement.setInt(1,previous_amount);
			 statement.setInt(2,id);
			 
			 
			 int affectedRows = statement.executeUpdate();
			 
			 if(affectedRows == 1) {
				 statement1 = conn.createStatement();
				 resultSet1 = statement1.executeQuery("SELECT acct_Balance FROM " + TABLE_NAME + 
						 							" WHERE " + COLUMN_ACCOUNTS_ID + " = " + id);
				 return resultSet1.getInt(1);
			 }
			  return 0;
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
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
	}
	
	public static TransactionBean performTransaction(int id1,int id2,int amount) {
		Connection conn = null;
		PreparedStatement statement = null;
		
		
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager.getConnection(CONNECTION_STRING);
			 
			 int latest_amount1 = updateAccountsWithDraw(id1,amount);
			 int latest_amount2 = updateAccounts(id2,amount);
			 
			 statement = conn.prepareStatement(TRANSACTION_QUERY);
			 statement.setInt(1, id1);
			 statement.setInt(2, latest_amount1);
			 statement.setInt(3, id2);
			 statement.setInt(4, latest_amount2);
			 
			 int affectedRows = statement.executeUpdate();
			 if(affectedRows == 1) {
				 TransactionBean tr = new TransactionBean();
				 tr.setSourceId(id1);
				 tr.setSourceAmt(latest_amount1);
				 tr.setTargetId(id2);
				 tr.setTargetAmt(latest_amount2);
				 
				 return tr;
			 }
			 
			 return null;
			
			  
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}finally {
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
