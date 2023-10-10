package Fuel.Class;

public class Fuel {

	private int id;
	private int stock_volume ;
	private int intial_volume;
	String date_recieved,date_consumed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock_volume() {
		return stock_volume;
	}
	public void setStock_volume(int stock_volume) {
		this.stock_volume = stock_volume;
	}
	public int getIntial_volume() {
		return intial_volume;
	}
	public void setIntial_volume(int intial_volume) {
		this.intial_volume = intial_volume;
	}
	public String getDate_recieved() {
		return date_recieved;
	}
	public void setDate_recieved(String date_recieved) {
		this.date_recieved = date_recieved;
	}
	public String getDate_consumed() {
		return date_consumed;
	}
	public void setDate_consumed(String date_consumed) {
		this.date_consumed = date_consumed;
	}
	
}
