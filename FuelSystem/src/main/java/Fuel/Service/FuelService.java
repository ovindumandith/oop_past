package Fuel.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fuel.Class.*;
import Fuel.Interfaces.*;
import Fuel.Util.DB;

public class FuelService implements Fuels{
	
	public int addFuel(Fuel fuel) {//parameter id /  return type int is used to know that the value return is 0 or 1 based on the fact that the database connection is returned successfully
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//insert value
			preparedStatement = connection.prepareStatement("insert into fuel (intial_volume, stock_volume, date_recieved, date_consumed ) values (?,?,?,?)");
			preparedStatement.setInt(1, fuel.getIntial_volume());// the values we get from the variable fuel we insert it into a fuel object and pass
			preparedStatement.setInt(2,fuel.getStock_volume());
			preparedStatement.setString(3,fuel.getDate_recieved());
			preparedStatement.setString(4,fuel.getDate_consumed());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			
			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public ArrayList<Fuel> getFuels() {//Array list are used to retrieve fuel data
		
		ArrayList<Fuel> fuelList = new ArrayList<Fuel>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DB.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM fuel");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Fuel fuel = new Fuel();

				fuel.setId(resultSet.getInt(1));
				fuel.setIntial_volume(resultSet.getInt(2));
				fuel.setStock_volume(resultSet.getInt(3));
				fuel.setDate_recieved(resultSet.getString(4));
				fuel.setDate_consumed(resultSet.getString(5));
				
				fuelList.add(fuel);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return fuelList;
	}

	public int editFuels(Fuel fuel) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
				//update value
				preparedStatement = connection.prepareStatement("UPDATE fuel SET intial_volume=?, stock_volume=?, date_recieved=?, date_consumed=? where id=?");
				preparedStatement.setInt(1, fuel.getIntial_volume());
				preparedStatement.setInt(2,fuel.getStock_volume());
				preparedStatement.setString(3,fuel.getDate_recieved());
				preparedStatement.setString(4,fuel.getDate_consumed());
				preparedStatement.setInt(5,fuel.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				return 1;
				
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteFuel(int fuel) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//delete fuel
			preparedStatement = connection.prepareStatement("DELETE FROM fuel WHERE id=?");
			preparedStatement.setInt(1, fuel);
			preparedStatement.execute();

			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}
	
	public Fuel getFuel(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Fuel fuel = new Fuel();
		
		try {
			connection = DB.getDBConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM fuel where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				fuel.setId(resultSet.getInt(1));
				fuel.setIntial_volume(resultSet.getInt(2));
				fuel.setStock_volume(resultSet.getInt(3));
				fuel.setDate_recieved(resultSet.getString(4));
				fuel.setDate_consumed(resultSet.getString(5));
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return fuel;
	}
	
}
