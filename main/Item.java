package main;

public class Item implements Comparable<Item> {

	// ID, name, description, price, and stock count.
	private String ID;
	private String name;
	private double price;
	private String description;
	private int stock_count;
	
	public Item(String id,String n, String d,double p,int s) {
		this.ID = id;
		this.name = n;
		this.price = p;
		this.description = d;
		this.stock_count = s;
	}
	
	public Item(String id ,String n, double p) {
		this.ID = id;
		this.name = n;
		this.price = p;
		this.description = "None";
		this.stock_count = 1;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public int getStock() {
		return this.stock_count;
	}
	
	public void setID(String id) {
		this.ID = id;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setPrice(double p) {
		this.price = p;
	}
	
	public void setDescription(String q) {
		this.description = q;
	}
	
	public void setStock(int s) {
		this.stock_count = s;
	}
	
	public double getSumPrice() {
		return this.stock_count * this.price;
	}
	
	public String toString() {
		String l = "Name : " + this.getName() + " \nID : "+this.ID +"\nDescription : " + this.description +"\nPrice : " + this.price +"\nStock : " + this.stock_count+"\n";
		return l ;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	
}
