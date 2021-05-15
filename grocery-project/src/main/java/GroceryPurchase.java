
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroceryPurchase {

	public static void main(String args[]) {
		Scanner readInput = new Scanner(System.in);
		String product = new String("empty");
		int quantity;
		double billAmount;
		GroceryBill groceryBill = new GroceryBill();
		List<String> productList = Arrays.asList("soup","bread","milk","apple");
		Map<String,Integer> purchaseCart = new HashMap<String,Integer>();
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("Welcome!!!! Below are products available in our store and the cost\n");
		System.out.println();
		System.out.println();
		System.out.println("Product		Unit		Cost");
		System.out.println("soup 		tin			" +GroceryProjectConstants.SOUP_COST);
		System.out.println("bread 		loaf		" +GroceryProjectConstants.BREAD_COST);
		System.out.println("milk 		bottle		" +GroceryProjectConstants.MILK_COST);
		System.out.println("apple 		single		" +GroceryProjectConstants.APPLE_COST);
		System.out.println();
		System.out.println("We have some interesting discounts available\n");
		System.out.println("Offer 1\n");
		System.out.println("Buy 2 tins of soup and get a loaf of bread half price, valid from yesterday and for next 7 days ");
		System.out.println("Offer 2\n");
		System.out.println("Apples have a 10% discount from 3 days hence until the end of the following month\n");
		System.out.println("PLease enter the date of purchase if you would like to purchase or press 00 to exit");
		String purchaseDate = readInput.next();
		if(purchaseDate.equals("00")){
			System.out.println("Meet you next time");
		}
		do{
			System.out.println("Please enter the product name(as per catalogue) and quantity or type quit to proceed for billing");
			product = readInput.next();
			if(product.equals("q")){
				System.out.println("Thank you for shopping");
				break;
			} 
			quantity = readInput.nextInt();
			if(quantity < 0) {
				System.out.println("Please check the quantity");
				quantity = readInput.nextInt();
				purchaseCart.put(product, quantity);
			}else {
				purchaseCart.put(product, quantity);	
			}
		}while(!product.equals("q")) ;

		billAmount = groceryBill.calculateBill(purchaseCart, purchaseDate);
		System.out.println("Your Bill amount is Rs."+df.format(billAmount));
		//System.out.println("Thank you for shopping");
	}
}
