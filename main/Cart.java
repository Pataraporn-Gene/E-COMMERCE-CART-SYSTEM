package main;

import iclass.LinkedList;

public class Cart {
	
	private LinkedList<Item> carts;
	private double totalPrice;
	
	public Cart() {
		carts = new LinkedList<Item>();
		totalPrice = 0;
	}
	
	public LinkedList<Item> getCarts(){
		return carts;
	}

	public double totalPrice(){
		return  this.totalPrice;
	}

	public void setTotalPrice_dis(double t){
		this.totalPrice = t;
	}
	
	public int add(String code, int stock) {
		if(Product.setNewStock(code,stock)) {
			Item item = ItemFactory.createItems(code,stock);	
			if(!cartContain(item)) {
				carts.add(item);
				return 0;
			}
			int oldStock = ((Item) carts.get(carts.indexOf(item))).getStock();
			((Item) carts.get(carts.indexOf(item))).setStock(stock + oldStock );
			return 0;
		}
		return -1;
	}
	
	public boolean remove(String code) {
		if(cartContain(code)) {
			Product.setBackStock(code);
			carts.remove(this.indexOf(code));
			return true;
		}
		return false;
	}
	
	public boolean changeAmount(String code, int new_amount) {
		if(new_amount == 0) {
			carts.remove(this.indexOf(code));
			return true;
		}
		if(cartContain(code)) {
			if(Product.setNewStock(code,new_amount-((Item) carts.get(this.indexOf(code))).getStock())) {
				((Item) carts.get(this.indexOf(code))).setStock(new_amount);	
				return true;
			}
		}
		return false;
	}
	
	public double getTotalPrice() {
		double total = 0.0;
		for(int i=0; i<carts.size();i++) {
			total += ((Item) carts.get(i)).getPrice() * ((Item) carts.get(i)).getStock();
		}
		this.totalPrice = total;
		return total;
	}
	
	public int indexOf(String code) {
		if(!carts.isEmpty()) {
			for(int i=0; i<carts.size();i++) {
				if(((Item) carts.get(i)).getID().equals(code)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean cartContain(String code) {
		return indexOf(code) >=0;
	}
	
	public boolean cartContain(Item i) {
		return this.cartContain(i.getID());
	}
	
	
	public void show() {
		String l = "_________________________________________________________\n\n";
		l += "                      Your Cart\n_________________________________________________________\n\n";
		if(carts.isEmpty()) {
			l+="             OH! It's EMPTY. Lets buy someting\n\n";
		}else {
			for(int i=0; i<carts.size();i++) {
				l+= (i+1) +".  "+((Item) carts.get(i)).getStock()+"x "+ ((Item) carts.get(i)).getName() +"["+ ((Item) carts.get(i)).getID() +"] --> "+ ((Item) carts.get(i)).getPrice() +" Baht\n\n";
			}
		}
		l = l + "                 ** TOTAL --> "+this.getTotalPrice() +" Baht **\n\n";
		l+= "_________________________________________________________\n";
		System.out.println(l);
	}
	
}
//i berbbooo