package Fuel.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fuel.Class.Customer;
import Fuel.Interfaces.Customers;
import Fuel.Util.DB;

public class CustomerService implements Customers{
	
	public int addCustomer(Customer customer) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//insert value
			preparedStatement = connection.prepareStatement("insert into customer (name, phone ,email, vehicleno, password) values (?,?,?,?,?)");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2,customer.getPhone());
			preparedStatement.setString(3,customer.getEmail());
			preparedStatement.setString(4,customer.getVehicleno());
			preparedStatement.setString(5,customer.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			
			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public ArrayList<Customer> getCustomers() {
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DB.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM customer");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Customer customer = new Customer();
				
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setPhone(resultSet.getString(3));
				customer.setEmail(resultSet.getString(4));
				customer.setVehicleno(resultSet.getString(5));
				customer.setPassword(resultSet.getString(6));
				
				customerList.add(customer);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return customerList;
	}

	public int editCustomers(Customer customer) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
				//update value
				preparedStatement = connection.prepareStatement("UPDATE customer SET name=? , phone=?, email=? , vehicleno=? , password=? where id=?");
				preparedStatement.setString(1, customer.getName());
				preparedStatement.setString(2,customer.getPhone());
				preparedStatement.setString(3,customer.getEmail());
				preparedStatement.setString(4,customer.getVehicleno());
				preparedStatement.setString(5,customer.getPassword());
				preparedStatement.setInt(6,customer.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				return 1;
				
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteCustomer(int customer) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//delete customer
			preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE id=?");
			preparedStatement.setInt(1, customer);
			preparedStatement.execute();

			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}
	
	public Customer getCustomer(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Customer customer = new Customer();
		
		try {
			connection = DB.getDBConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM customer where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setPhone(resultSet.getString(3));
				customer.setEmail(resultSet.getString(4));
				customer.setVehicleno(resultSet.getString(5));
				customer.setPassword(resultSet.getString(6));
				
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}
	
}
