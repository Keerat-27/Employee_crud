package com.sims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.beans.Employee;
import com.sims.connection.GetConnection;

public class EmployeeDAO {
	public boolean insertEmployee(Employee employee) {
		String sql="insert into employee values (?,?,?,?)";
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			
			
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			ps.setDouble(3, employee.getEmpSal());
			ps.setString(4, employee.getEmpMail());
			
			return ps.executeUpdate()>0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEmployee(int empId) {
		String sql = "delete from employee where empId = ?";
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);			
			ps.setInt(1, empId);
	
			return ps.executeUpdate()>0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployee(int empId, String empMail) {
		String sql = "update employee set empmail = ? where empid = ?";
		
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setString(1, empMail);
			ps.setInt(2, empId);
			
			return ps.executeUpdate()>0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee getEmployee(int empId) {
		
		String sql = "select * from employee where empid =?";
		
		try {
			PreparedStatement ps =GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpSal(rs.getDouble(3));
				employee.setEmpMail(rs.getString(4));
				
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> list = null;
		try {
			list = new ArrayList<Employee>();
			String sql = "select * from employee";
			PreparedStatement ps =GetConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpSal(rs.getDouble(3));
				employee.setEmpMail(rs.getString(4));
				
				list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
