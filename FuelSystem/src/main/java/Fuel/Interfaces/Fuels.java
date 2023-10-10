package Fuel.Interfaces;

import java.util.ArrayList;

import Fuel.Class.Fuel;

public interface Fuels {

	public int addFuel(Fuel f);
	
	public int editFuels(Fuel f);
	
	public Fuel getFuel(int f);

	public int deleteFuel(int f);

	public ArrayList<Fuel> getFuels();
	
}
