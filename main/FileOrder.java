package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileOrder {
	
	
	public static void readOrder(String filepath) {
		Shop shop = new Shop();
        try {
			BufferedReader reader = new BufferedReader( new InputStreamReader (new FileInputStream(new File (filepath))));
			String line;
			while((line = reader.readLine()) != null && !(line.equals("PAYMENT"))) {
				String[] l = line.split(" ");
				String code = l[0];
				int amount = Integer.parseInt(l[1]);
				shop.stateOrder(1, code, amount);
			}
			int payment = Integer.parseInt(reader.readLine());
			shop.checkpayment(payment, "none");
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
