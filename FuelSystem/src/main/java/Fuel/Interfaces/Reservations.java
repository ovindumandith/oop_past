package Fuel.Interfaces;

import java.util.ArrayList;

import Fuel.Class.Reservation;

public interface Reservations {

	public int addReservation(Reservation driver);
	
	public int editReservations(Reservation driver);
	
	public Reservation getReservation(int d);

	public int deleteReservation(int d);

	public ArrayList<Reservation> getReservations();
	
}
