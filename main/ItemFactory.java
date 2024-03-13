package main;

public class ItemFactory {
	
	
	public static Item createItems(String code) {
		switch (code) {
		case "J001" : return new Item(code, "Cargo Jeans", "Cargo Jeans for Women High Waistd.", 899, 10	 );
		case "D002" : return new Item(code, "Summer dress", "2023 Spring Summer Deep V Neck Long Sleeve", 799, 10);
		case "T003" : return new Item(code, "Classic T-shirts", "Women's Classic-Fit Short-Sleeve V-Neck T-Shirt", 450, 10);
		case "S004" : return new Item(code , "Sneaker", "Womean's white sneaker", 999, 5);
		case "H005" : return new Item(code, "Pink Hoodie", "Unisex SpongeBob SquarePants Fleece Sweatshirt", 599.0, 10) ;
		default : return null;
		}
	}
	
	public static Item createItems(String code, int amount) {
		switch (code) {
		case "J001" : return new Item(code, "Cargo Jeans", "Cargo Jeans for Women High Waistd.", 899, amount	 );
		case "D002" : return new Item(code, "Summer dress", "2023 Spring Summer Deep V Neck Long Sleeve", 799, amount);
		case "T003" : return new Item(code, "Classic T-shirts", "Women's Classic-Fit Short-Sleeve V-Neck T-Shirt", 450, amount);
		case "S004" : return new Item(code , "Sneaker", "Womean's white sneaker", 999, amount);
		case "H005" : return new Item(code, "Pink Hoodie", "Unisex SpongeBob SquarePants Fleece Sweatshirt", 599.0, amount) ;
		default : return null;
		}
	}
}
