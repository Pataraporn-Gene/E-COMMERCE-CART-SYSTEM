package main;

import java.util.Scanner;

public class Shop {
	
	 public Scanner sc = new Scanner(System.in);

	 private Product products;
	 private String[] items = {"J001","D002","T003","S004", "H005"};
	 private Cart carts;
	 
	 public Shop() {
		 products = new Product();
		 carts = new Cart();
		 Open();
	 }
	
	 
	 public void stateOrder(int state) {
		 String code ;
		 int amount;
		 switch(state) {
		 case 1: 
			 System.out.print("\nItem ID : ");  
			 code = sc.next();
			
			 while(!checkCode(code)) {
				 if(code.equals("0")) {
					 break;
				 } 
				 System.out.print("\nItem ID : ");  
				 code = sc.next();
			 }
			 
			 if(code.equals("0")) {break;}
			 
			 System.out.print("Amount : ");
			 amount = sc.nextInt();
			 
			 addToCart(code,amount);
			 display();
			 break;
		 case 2:
			 carts.show();
			 System.out.print("Item's ID you want to remove : ");
			 code = sc.next();
			 while(!checkCode(code)) {
				 if(code.equals("0")) {
					 break;
				 } 
				 System.out.print("\nItem ID : ");  
				 code = sc.next();
			 }
			 if(code.equals("0")) {break;}
			 
			 removeOrder(code);
			 carts.show();
			 instruction();
			 break;
		 case 3:   
			 System.out.print("Type Item's ID you want to change : ");
			 code = sc.next();
			 
			 while(!checkCode(code)) {
				 if(code.equals("0")) {
					 break;
				 } 
				 System.out.print("\nItem ID : ");  
				 code = sc.next();
			 }
			 
			 if(code.equals("0")) {break;}	
			 
			 if(!carts.cartContain(code)) {
				 System.out.println("\n              This cart doesn't have "+ code +" \n");
				 carts.show();
				 break;
			}
			 System.out.print("What amount you want : ");
			 amount = sc.nextInt();
			 change(code,amount);
			 break;
		 case 4:
			 display();
			 System.out.print("Which Item you want to see detail : ");
			 code = sc.next();
			
			 while(!checkCode(code)) {
				 if(code.equals("0")) {
					 break;
				 } 
				 System.out.print("\nItem ID : ");  
				 code = sc.next();
			 }
			 
			 if(code.equals("0")) {break;}			 
			 products.showItemDetail(code);
			 break;
		 case 5:    
			 carts.show();
			 instruction();
			 break;
		 case 6:   
			 instruction();
			 break;
		 case 7:
			 display();
			 break;
		 case 8:    
			 if(carts.getCarts().isEmpty()) {
				 System.out.println("\n       ** Your cart is EMPTY, Lets buy something **\n\n");
				 break;
			 }
			 checkout();    
			 break;
		 case 9: 
			 checkpayment();
			 break;
		 default: System.out.println("Invalid State Please Try again."); 
		}
	 }
	 
	 public void stateOrder(int state, String code,int amount) {
		 switch(state) {
		 case 1: addToCart(code,amount); display(); break;
		 case 2: removeOrder(code); carts.show(); instruction(); break;
		 case 3: change(code,amount); break;
		 case 4: products.showItemDetail(code); break;
		 case 5: carts.show(); instruction(); break;
		 case 6: instruction(); break;
		 case 7: checkout(); break;
		 case 8: checkpayment(amount,code); break;
		 default: System.out.println("Invalid state, Please Try Again");
		 }
	 }
	 
	 
	 private void addToCart(String code, int stock) {
		if(carts.add(code, stock)!=-1) {
			System.out.println("\n            ** Your order has been add.**\n");
		}else {
			 System.out.println("\n  --Invalid Stock Please Try Again.--\n");
		}
	
	 }
	 
	 private void removeOrder(String code) {
		if(carts.remove(code)) {
			System.out.println("\n           **Item " +code+ " has been removed.**\n");
		}else {
			 System.out.println("\n   --No Item ID " + code +" in the cart.--\n");
		}
	 }
	 
	 private void change(String code, int new_amount) {
		if(carts.changeAmount(code, new_amount)) {
			System.out.println("\n            ** Your order is already update **\n");
		 }else {
			System.out.println("\n            ** Sorry we cannot update you amount **\n");
		}
	 }
	 
	 
	private boolean checkCode(String code) {
			for(int i=0; i<items.length;i++) {
				if(items[i].equals(code)) {
					return true;
				}
			}
			System.out.println("\n  --Invalid Code Please Try Again.--\n");
			return false;
	 }
	
	 public void Open() {
		 for(int i =0 ; i< items.length;i++) {
			 products.add(items[i]);
		 }
		 System.out.println("-----------------------GEnE's sHoP-----------------------");
		 display();
		 instruction();
	 }
	 
	 public void display() {
		 System.out.println("_________________________________________________________\n");
		 String format = "                      ";
		 System.out.println("ID   Name                   Price         Stock");
		 System.out.println("_________________________________________________________\n");
		 for(int i=0;i<products.getProducts().size();i++) {
			 Item it = (Item) products.getProducts().get(i);
			 int space = format.length() - it.getName().length();
			 System.out.print(it.getID() + " " + it.getName());
			 while(space>=0) {
				 System.out.print(" ");
				 space--;
			 }
			 System.out.printf("%.2f Baht   ", it.getPrice());
			 System.out.println("[ " + it.getStock() + " ]");
		 }
		 System.out.println("_________________________________________________________\n");
	 }
	
	 public void instruction() {
		 System.out.println("-----------------------Instruction-----------------------\n");
		 System.out.println("Press 1 to 'ADD' order ");
		 System.out.println("Press 2 to 'REMOVE' order ");
		 System.out.println("Press 3 to 'CHANGE' order ");
		 System.out.println("Press 4 to 'VIEW' item's detail");
		 System.out.println("Press 5 to 'OPEN' your carts ");
		 System.out.println("Press 6 to 'INSTRUCTION' ");
		 System.out.println("Press 7 to 'MENU'");
		 System.out.println("Press 8 to 'CHECK OUT'\n");
		 System.out.println("---------------------------------------------------------\n");
	 }
	 
	
	 public void checkout() {
		 	System.out.println("\n\nPlease confirm you order");
		 	System.out.println("_________________________________________________________\n");
			String format = "                 ";
			System.out.println("ID   Name                   Price         Amount");
			System.out.println("_________________________________________________________\n");
			for(int i=0;i<carts.getCarts().size();i++) {
				Item it = (Item) carts.getCarts().get(i);
				int space = format.length() - it.getName().length();
				System.out.print((i+1) +".)  " +it.getID() + " " + it.getName());
				while(space>=0) {
					System.out.print(" ");
					space--;
				}
				System.out.printf("%.2f Baht   ", it.getPrice());
				System.out.println("x" + it.getStock());
			}
			System.out.println("_________________________________________________________\n");
			System.out.println("TOTAL PRICE : " + carts.getTotalPrice() +" Baht");
			System.out.println("_________________________________________________________\n");
			System.out.println("If there're no change Press 9");
	 }
	 
	 public void checkpayment(){
		System.out.println("_________________________________________________________\n");
		System.out.println("What you want to pay with?");
		System.out.println("Press 1 -> CASH");
		System.out.println("Press 2 -> CARD");
		System.out.println("Press 3 -> ONLINE BANKING");
		System.out.println("Press 4 -> QR CODE");
		System.out.print("\n\nPress ---> ");
		int type = sc.nextInt();
		System.out.println("\n\nYou have any discount?  ( If NO type 'none' )");
		System.out.print("\nDISCOUNT --->  ");
		String discount = sc.next();
		paymentmethod(type,discount);
	 }
	 
	 public void checkpayment(int type, String discount){
			System.out.println("_________________________________________________________\n");
			System.out.println("What you want to pay with?");
			System.out.println("Press 1 -> CASH");
			System.out.println("Press 2 -> CARD");
			System.out.println("Press 3 -> ONLINE BANKING");
			System.out.println("Press 4 -> QR CODE");
			System.out.print("\n\nPress ---> ");
			System.out.println("\n\nYou have any discount?  ( If NO type 'none' )");
			System.out.print("\nDISCOUNT --->  ");
			paymentmethod(type,discount);
		 }


	 public void paymentmethod(int type, String discount){
		
		System.out.println("\n_________________________________________________________\n");
		Payment payment = new Payment(carts, type ,discount);
		if(payment.checkdiscount()) {
			 System.out.println("Total                                        "+carts.getTotalPrice());
			 System.out.print("Discount *"+ payment.getDiscountType() +"*" );
			 String format = "                                 ";
			 int space = format.length() - payment.getDiscountType().length();
			 while(space>=0) {
				 System.out.print(" ");
				 space--;
			 }
			 System.out.println(payment.getDiscountPrice());
			System.out.println("\n_________________________________________________________\n");
		}
		System.out.println("\n               PAY BY " + payment.getType()+"  SUCCESS  \n");
		System.out.println("_________________________________________________________\n\n");
		
		printRecipt(payment);
	 }
	 
	 public void printRecipt(Payment payment) {
		 System.out.println("========================================================\n");
		 System.out.println("                    CUSTOMER INVOICE                    \n");
		 System.out.println("========================================================");
		 System.out.println("                    GEnE's sHop.com");
		 System.out.println("             No 300847 Address 999/9 Rama I Rd, ");
		 System.out.println("                 Pathum Wan, Bangkok 10330");
		 System.out.println("========================================================");
		 System.out.println("Item    Name                                 Price");
		 System.out.println("========================================================");
		 for(int i=0; i<carts.getCarts().size();i++) {
			 Item item = (Item) carts.getCarts().get(i);
			 System.out.println(item.getID() +"    " + item.getName());
			 System.out.print("        "+item.getStock() +" x " + item.getPrice());
			 System.out.println("                            " +item.getSumPrice());
			 
		 }
		 System.out.println("========================================================");
		 System.out.println("Total                                        "+carts.getTotalPrice());
		 System.out.print("Discount *"+ payment.getDiscountType() +"*" );
		 String format = "                                 ";
		 int space = format.length() - payment.getDiscountType().length();
		 while(space>=0) {
			 System.out.print(" ");
			 space--;
		 }
		 System.out.println(payment.getDiscountPrice());
		 System.out.println("========================================================\n");
		 System.out.println("Total amount                                 "+ (carts.totalPrice()-payment.getDiscountPrice()));
		 System.out.println("\n********************************************************");
		 System.out.println("\n                  THANK YOU SEE YOU AGAIN");
		 System.out.println("\n********************************************************");
		 System.out.println("                System by : Pataraporn GENE");
		 System.out.println("           pataraporn.pen@student.mahidol.ac.th");
	 }
	 
}
