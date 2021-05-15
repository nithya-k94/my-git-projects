import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GroceryTest {

	private GroceryBill groceryBill = new GroceryBill();
	DecimalFormat df = new DecimalFormat("###.##");
	private Map<String,Integer> purchaseMap = new HashMap<String,Integer>();
	@Test
	public void checkBillWithoutDiscount() {
		double expectedBillAmount = 8.55;
		purchaseMap.put("apple", 3);
		purchaseMap.put("soup", 3);
		purchaseMap.put("milk", 3);
		purchaseMap.put("bread", 3);
		String purchaseDate = "12-05-2021";
		double actualBillAmount = Double.parseDouble(df.format(groceryBill.calculateBill(purchaseMap, purchaseDate)));
		Assert.assertEquals(expectedBillAmount, actualBillAmount,0.05);
	}
	
	@Test
	public void checkBillWithDiscount1() {
		double expectedBillAmount = 8.15;
		purchaseMap.put("apple", 3);
		purchaseMap.put("soup", 3);
		purchaseMap.put("milk", 3);
		purchaseMap.put("bread", 3);
		String purchaseDate = "15-05-2021";
		double actualBillAmount = Double.parseDouble(df.format(groceryBill.calculateBill(purchaseMap, purchaseDate)));
		Assert.assertEquals(expectedBillAmount, actualBillAmount,0.05);
	}
	
	@Test
	public void checkBillWithDiscount2() {
		double expectedBillAmount = 8.52;
		purchaseMap.put("apple", 3);
		purchaseMap.put("soup", 3);
		purchaseMap.put("milk", 3);
		purchaseMap.put("bread", 3);
		String purchaseDate = "22-05-2021";
		double actualBillAmount = Double.parseDouble(df.format(groceryBill.calculateBill(purchaseMap, purchaseDate)));
		Assert.assertEquals(expectedBillAmount, actualBillAmount,0.05);
	}
	
	@Test
	public void checkBillWithBothDiscounts() {
		double expectedBillAmount = 8.12;
		purchaseMap.put("apple", 3);
		purchaseMap.put("soup", 3);
		purchaseMap.put("milk", 3);
		purchaseMap.put("bread", 3);
		String purchaseDate = "19-05-2021";
		double actualBillAmount = Double.parseDouble(df.format(groceryBill.calculateBill(purchaseMap, purchaseDate)));
		Assert.assertEquals(expectedBillAmount, actualBillAmount,0.05);
	}
}
