package Fuel.Interfaces;

import java.util.ArrayList;

import Fuel.Class.Customer;

public interface Customers {

	public int addCustomer(Customer c);
	
	public int editCustomers(Customer c);
	
	public Customer getCustomer(int c);

	public int deleteCustomer(int c);

	public ArrayList<Customer> getCustomers();
	
}
