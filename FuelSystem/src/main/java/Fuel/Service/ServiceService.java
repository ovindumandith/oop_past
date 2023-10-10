package Fuel.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fuel.Class.*;
import Fuel.Interfaces.*;
import Fuel.Util.DB;

public class ServiceService implements Services{
	
	public int addService(Service service) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//insert value
			preparedStatement = connection.prepareStatement("insert into service (name, status, fee) values (?,?,?)");
			preparedStatement.setString(1, service.getName());
			preparedStatement.setString(2,service.getStatus());
			preparedStatement.setDouble(3,service.getFee());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			
			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public ArrayList<Service> getServices() {
		
		ArrayList<Service> serviceList = new ArrayList<Service>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DB.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM service");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Service service = new Service();
				
				service.setId(resultSet.getInt(1));
				service.setName(resultSet.getString(2));
				service.setStatus(resultSet.getString(3));
				service.setFee(resultSet.getDouble(4));
				
				serviceList.add(service);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return serviceList;
	}

	public int editServices(Service service) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
				//update value
				preparedStatement = connection.prepareStatement("UPDATE service SET name=?, status=?, fee=? where id=?");
				preparedStatement.setString(1, service.getName());
				preparedStatement.setString(2,service.getStatus());
				preparedStatement.setDouble(3,service.getFee());
				preparedStatement.setInt(4,service.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				return 1;
				
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteService(int service) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//delete service
			preparedStatement = connection.prepareStatement("DELETE FROM service WHERE id=?");
			preparedStatement.setInt(1, service);
			preparedStatement.execute();

			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}
	
	public Service getService(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Service service = new Service();
		
		try {
			connection = DB.getDBConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM service where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				service.setId(resultSet.getInt(1));
				service.setName(resultSet.getString(2));
				service.setStatus(resultSet.getString(3));
				service.setFee(resultSet.getDouble(4));
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return service;
	}
	
}
