package Fuel.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fuel.Class.*;
import Fuel.Interfaces.*;
import Fuel.Util.DB;

public class ReservationService implements Reservations{
	
	public int addReservation(Reservation reservation) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//insert value
			preparedStatement = connection.prepareStatement("insert into reservation (service_type, vehicle_no, date, payment_status ) values (?,?,?,?)");
			preparedStatement.setString(1, reservation.getService_type());
			preparedStatement.setString(2,reservation.getVehicle_no());
			preparedStatement.setString(3,reservation.getDate());
			preparedStatement.setString(4,reservation.getPayment_status());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			
			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public ArrayList<Reservation> getReservations() {
		
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DB.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM reservation");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Reservation reservation = new Reservation();
				
				reservation.setId(resultSet.getInt(1));
				reservation.setService_type(resultSet.getString(2));
				reservation.setVehicle_no(resultSet.getString(3));
				reservation.setDate(resultSet.getString(4));
				reservation.setPayment_status(resultSet.getString(5));
				
				reservationList.add(reservation);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return reservationList;
	}

	public int editReservations(Reservation reservation) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
				//update value
				preparedStatement = connection.prepareStatement("UPDATE reservation SET service_type=?, vehicle_no=?, date=?, payment_status=? where id=?");
				preparedStatement.setString(1, reservation.getService_type());
				preparedStatement.setString(2,reservation.getVehicle_no());
				preparedStatement.setString(3,reservation.getDate());
				preparedStatement.setString(4,reservation.getPayment_status());
				preparedStatement.setInt(5,reservation.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				return 1;
				
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteReservation(int reservation) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DB.getDBConnection();
			
			//delete reservation
			preparedStatement = connection.prepareStatement("DELETE FROM reservation WHERE id=?");
			preparedStatement.setInt(1, reservation);
			preparedStatement.execute();

			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}
	
	public Reservation getReservation(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Reservation reservation = new Reservation();
		
		try {
			connection = DB.getDBConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM reservation where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				reservation.setId(resultSet.getInt(1));
				reservation.setService_type(resultSet.getString(2));
				reservation.setVehicle_no(resultSet.getString(3));
				reservation.setDate(resultSet.getString(4));
				reservation.setPayment_status(resultSet.getString(5));
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return reservation;
	}
	
}
