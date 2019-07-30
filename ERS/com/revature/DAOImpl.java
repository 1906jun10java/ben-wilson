package com.revature.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.Employees;
import com.revature.beans.Requests;
import com.revature.util.ConnectionUtil;

public class DAOImpl implements DAO{
	public int login(String user, String pass) {
		int status =0;
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "SELECT LOGIN.UPASSWORD FROM LOGIN WHERE USERNAME=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
		
				String Cpass = rs.getString("UPASSWORD");
				 if (pass.equals(Cpass)) {
				
					 String sql2 = "SELECT * FROM LOGIN WHERE USERNAME=?";
					 PreparedStatement stmt2 = con.prepareStatement(sql2);
					 stmt2.setString(1, user);
					 ResultSet rs2 = stmt2.executeQuery();
					 if (rs2.next()) {
						 
						int userId = rs2.getInt("EMP_ID");
					
						return userId;

					 }else {
						 
					 status = 0;
					 return status;
				 }
			}
      }} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
  		return status = 0;
	}
	

	@Override
	public void newRequests(Employees emp, float amt, String cat, String details) {
		try (Connection con = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO REQUESTS  (EMP_ID, AMT, CATEGORY, DETAILS)" + 
					"VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, emp.getId());
			stmt.setFloat(2, amt);
			stmt.setString(3, cat);
			stmt.setString(4, details);
			stmt.executeUpdate();
		
		}
			catch(SQLException | IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public ArrayList<Requests> myRequests(int userId) {
		ArrayList<Requests> list = new ArrayList<Requests>();
	
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REQUESTS WHERE EMP_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				int req_id = rs.getInt("REQ_ID");
				float amt = rs.getFloat("AMT");
				String status = rs.getString("STATUS");
				String cat = rs.getString("CATEGORY");
				String detail = rs.getString("DETAILS");
				
				list.add(new Requests (req_id, myInfo(userId), amt, status, cat, detail));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	public ArrayList<Requests> myPendingRequests(int userId) {
		ArrayList<Requests> list = new ArrayList<Requests>();
		
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REQUESTS WHERE EMP_ID = ? AND STATUS='Pending' ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int req_id = rs.getInt("REQ_ID");
				float amt = rs.getFloat("AMT");
				String status = rs.getString("STATUS");
				String cat = rs.getString("CATEGORY");
				String detail = rs.getString("DETAILS");
				
				list.add(new Requests (req_id, myInfo(userId), amt, status, cat, detail ));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Requests> myResolvedRequests(int userId) {
		ArrayList<Requests> list = new ArrayList<Requests>();
		
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REQUESTS WHERE EMP_ID = ? AND STATUS != 'Pending'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int req_id = rs.getInt("REQ_ID");
				float amt = rs.getFloat("AMT");
				String status = rs.getString("STATUS");
				String cat = rs.getString("CATEGORY");
				String detail = rs.getString("DETAILS");
				list.add(new Requests (req_id, new Employees(), amt, status, cat, detail ));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Employees myInfo(int userId) {
		Employees E = null;
		try (Connection con = ConnectionUtil.getConnection()){

			String sql = "SELECT * FROM EMPLOYEES "
					+ "WHERE EMPLOYEES.EMP_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, userId);
		
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("EMP_ID");
				int boss = rs.getInt("REPORTS_TO");
				String fName=rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				E = new Employees (id, boss, fName, lName);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return E;
	}

	@Override
	public void updateMyInfo(String newFName, String newLName, int userId) {
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ? WHERE EMP_ID = ?";
			System.out.println(newFName+newLName);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, newFName);
			stmt.setString(2, newLName);
			stmt.setInt(3, userId);
			System.out.println("UPINFO");
			stmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Requests> pendingRequests(int userId) {
	
	ArrayList<Requests> list = new ArrayList<Requests>(); 
		
	try (Connection con = ConnectionUtil.getConnection()){
				
			String sql = "SELECT EMP_ID FROM EMPLOYEES WHERE REPORTS_TO = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
				
			while (rs.next()) { 
					
				int empId = rs.getInt("EMP_ID");
				
				String sql2 = "SELECT * FROM REQUESTS WHERE EMP_ID = ? AND STATUS='Pending'";
				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setLong(1, empId);
				ResultSet rs2 = stmt2.executeQuery();
				while (rs2.next()) {	
					int req_id = rs2.getInt("REQ_ID");
					float amt = rs2.getFloat("AMT"); 
					String status = rs2.getString("STATUS");
					String cat = rs2.getString("CATEGORY");
					String detail = rs2.getString("DETAILS");
					
					list.add(new Requests (req_id, myInfo(empId), amt, status, cat, detail ));
				}
			}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return list;
		
		
	}

	@Override
	public ArrayList<String> viewReciepts(int userId) {
		return null;
	}

	@Override
	public ArrayList<Requests> resolvedRequests(int userId) {
		ArrayList<Requests> list = new ArrayList<Requests>();
		
	try (Connection con = ConnectionUtil.getConnection()){
			
			String sql = "SELECT EMP_ID FROM EMPLOYEES WHERE REPORTS_TO = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				
				int empId = rs.getInt("EMP_ID");
				
				String sql2 = "SELECT * FROM REQUESTS WHERE EMP_ID = ? AND STATUS != 'Pending'"; 
				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setLong(1, empId);
				ResultSet rs2 = stmt2.executeQuery(); 
				while (rs2.next()) {
					int req_id = rs2.getInt("REQ_ID");
					int id = rs2.getInt("EMP_ID");
					float amt = rs2.getFloat("AMT");
					String status = rs2.getString("STATUS");
					String cat = rs2.getString("CATEGORY");
					String detail = rs2.getString("DETAILS");
					
					list.add(new Requests (req_id, myInfo(id), amt, status, cat, detail ));

				}
		
			}
	} catch (SQLException | IOException e) {
		e.printStackTrace();
	} return list;
		
	}


	@Override
	public ArrayList<Employees> myEmployees(int userId) {
		ArrayList<Employees> list = new ArrayList<Employees>();
		
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES WHERE REPORTS_TO = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("EMP_ID");
				int boss = rs.getInt("REPORTS_TO");
				String fName=rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				list.add(new Employees (id, boss, fName, lName));
			}
		} catch (SQLException | IOException  e) {
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public ArrayList<Requests> theirRequests(int userId, int id) {
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEES.EMP_ID=? AND REPORTS_TO=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.setLong(2, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return myRequests(id);
			}
			else {
				System.out.println("NOT SUBORD");
				return null;
				}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void resolveRequests(int reqId, String status) {
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "UPDATE REQUESTS SET STATUS = ? WHERE REQ_ID = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setInt(2, reqId);
			stmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
