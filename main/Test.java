package main;
import java.util.Scanner;

public class Test {
	
	public static void autoTest() {
		int[] states = {1,1,1,2,1,3,4,5,1,6,7,8};
		String[] IDs= {"J001","D002","S004","D002","D002","J001","H005","T003","2","0","0","runnwithme"};
		int[] amounts = {1,2,1,0,5,4,0,0,2,0,0,3};
		
		Shop shop = new Shop();
		
		for(int i=0; i<states.length;i++) {
			shop.stateOrder(states[i], IDs[i], amounts[i]);
		}
	}

	public static void testManual() {
		Shop shop = new Shop();
		
		Scanner sc = new Scanner(System.in);
		int state;
		do {
			System.out.println("'0' to exit STATE");
			System.out.print("Press -> ");
			state = sc.nextInt();
			if(state == 0) {
				break;
			}
			shop.stateOrder(state);
		}while(state != 9);
	}
	
	public static void TestFile(String file) {
		FileOrder.readOrder(file);
	}
	
	public static void main(String[] agrs) {		
		autoTest();
		// testManual();
		// TestFile("C:\\Users\\Pam\\eclipse-workspace\\Project1\\src\\order1");

	}
	
}
