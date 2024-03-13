package main;

import iclass.ArrayList;

public class Product {
	
	private static ArrayList<Item> products;
	
	public Product() {
		products = new ArrayList<Item>();
	}
	
	public void add(String code) {
		Item item = ItemFactory.createItems(code);
		if(item != null) {
			if(products.isEmpty()) {
				products.add(item);
			}else {
				boolean check = true;
				for(int i =0; i<products.size();i++) {
					Item t = (Item) products.get(i);
					if(t.getName().equals(item.getName())) {
						t.setStock(t.getStock()+item.getStock());
						check = false;
						break;
					}
				}
				if(check) {
					products.add(item);
				}
			}
		}
	}
	
	public  ArrayList<Item> getProducts(){
		return products;
	}
	
	
	public void add(Item e) {
		if(products.isEmpty()) {
			products.add(e);
		}else {
			boolean check = true;
			for(int i =0; i<products.size();i++) {
				Item t = (Item) products.get(i);
				if(t.getName().equals(e.getName())) {
					t.setStock(t.getStock()+e.getStock());
					check = false;
					break;
				}
			}
			if(check) {
				products.add(e);
			}
		}
	}
	
	
	public static boolean setNewStock(String code ,int nstock) {
		Item it = ItemFactory.createItems(code);
		if(it!=null) {
			if(contains(it)){
				int i = indexOf(it);
				Item item = (Item) products.get(i);
				if(checkStock(item,nstock)) {
					item.setStock(item.getStock()-nstock);
					products.set(i, item);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean setNewStock(Item item ,int nstock) {
		if(contains(item)){
			int i = products.indexOf(item);
			if(checkStock(item,nstock)) {
				item.setStock(item.getStock()-nstock);
				products.set(i, item);
				return true;
			}
		}
		return false;
	}
	
	public static void setBackStock(String code) {
		Item item = ItemFactory.createItems(code);
		products.set(indexOf(code), item);
	}
		
	public static boolean contains(Item e) {
		if(products.isEmpty()) {
			return false;
		}
		for(int i=0; i<products.size();i++) {
			if(((Item) products.get(i)).getID().equals(e.getID())) {
				return true;
			}
		}
		return false;
	}
	
	public static int indexOf(Item e) {
		if(!products.isEmpty()) {
			for(int i=0; i<products.size();i++) {
				if(e.getID().equals(((Item) products.get(i)).getID())) {
					return i;
				}
			}
		}
		return -1;
	}
	public static int indexOf(String code) {
		if(!products.isEmpty()) {
			for(int i=0; i<products.size();i++) {
				if(code.equals(((Item) products.get(i)).getID())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	private static boolean checkStock(Item item , int nstock) {
		return nstock <= ((Item) products.get(products.indexOf(item))).getStock() ;
	}
	
	@SuppressWarnings("static-access")
	public void showItemDetail(String code) {
		System.out.println(this.products.get(indexOf(code)).toString());
	}

	public String toString() {
		String l = "";
		for(int i =0; i<products.size();i++) {
			l += ((Item)products.get(i)).toString();
		}
		return l;
	}
	
}
