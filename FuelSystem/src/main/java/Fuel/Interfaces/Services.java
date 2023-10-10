package Fuel.Interfaces;

import java.util.ArrayList;

import Fuel.Class.Service;

public interface Services {

	public int addService(Service driver);
	
	public int editServices(Service driver);
	
	public Service getService(int d);

	public int deleteService(int d);

	public ArrayList<Service> getServices();
	
}
