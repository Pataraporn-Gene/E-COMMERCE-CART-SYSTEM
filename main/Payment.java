package main;

public class Payment {
    
    private Cart carts;
    private String type;
    private String discount;
    private double discount_price;

    public Payment(Cart c ,int t, String d){
        carts = c;
        if(d.equals("none")) {
        	discount = "NONE";
        }else {
        	discount = d;
        }
        switch(t){
            case 1: type = "CASH"; break;
            case 2: type = "CARD"; break;
            case 3: type = "ONLINE BANKING"; break;
            case 4: type = "QR CODE"; break;
        }
        discount_price = 0;
    }

    public Payment(Cart c, int t){
        carts = c;
        discount = "NONE";
        switch(t){
            case 1: type = "CASH"; break;
            case 2: type = "CARD"; break;
            case 3: type = "ONLINE BANKING"; break;
            case 4: type = "QR CODE"; break;
        }  
        discount_price = 0;
    }

    public String getType(){
        return type;
    }

    public String getDiscountType(){
        return this.discount;
    }
    
    public double getDiscountPrice() {
    	return this.discount_price;
    }

    public boolean checkdiscount(){
        if(!discount.equals("NONE")){
            switch(this.discount){
                case "spe1107": carts.setTotalPrice_dis(carts.totalPrice()*1.05); break;
                case "summertime": carts.setTotalPrice_dis(carts.totalPrice()-this.summertimeDiscount())  ; break;
                case "runnwithme": carts.setTotalPrice_dis(carts.totalPrice()-this.runwithDiscount()) ;  break;
            }
            return true;
        }
        return false;
    }

    public double summertimeDiscount(){
    	double discountprice =0.0;
        if(carts.cartContain("D002")){
            Item item = (Item) carts.getCarts().get(carts.indexOf("D002"));
            discountprice = (item.getPrice()*0.5) * item.getStock();
        }
        discount_price = discountprice;
        return discountprice;
    }
    
    public double runwithDiscount(){
    	double discountprice =0.0;
        if(carts.cartContain("S004")){
            Item item = (Item) carts.getCarts().get(carts.indexOf("S004"));
            discountprice = (item.getPrice()*0.5) * item.getStock();
        }
        discount_price = discountprice;
        return discountprice;
    }
    
    

}
