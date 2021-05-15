
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class GroceryBill {

	public double calculateBill(Map<String,Integer> purchaseCart,String purchaseDate) {
		double billAmount = 0;
		int soupQuantity;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(purchaseDate, formatter);
		LocalDate yesterday = LocalDate.now().minusDays(1);
		LocalDate offer1ValidDate = yesterday.plusWeeks(1);
		LocalDate offer2ValidFrom = LocalDate.now().plusDays(3);
		LocalDate offer2ValidTo = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), offer2ValidFrom.lengthOfMonth());
		if(purchaseCart.containsKey(GroceryProjectConstants.SOUP_PRODUCT)) {
			billAmount += purchaseCart.get(GroceryProjectConstants.SOUP_PRODUCT) * GroceryProjectConstants.SOUP_COST;
		}
		if(purchaseCart.containsKey(GroceryProjectConstants.BREAD_PRODUCT)) {
			if(purchaseCart.containsKey(GroceryProjectConstants.SOUP_PRODUCT) &&
					purchaseCart.get(GroceryProjectConstants.SOUP_PRODUCT) >= 2 && 
					date.isAfter(yesterday) && date.isBefore(offer1ValidDate)) {
				soupQuantity = (int) Math.floor(purchaseCart.get(GroceryProjectConstants.SOUP_PRODUCT)/2);
				int breadQuantity = purchaseCart.get(GroceryProjectConstants.BREAD_PRODUCT);
				if(breadQuantity > soupQuantity) {
					billAmount += (breadQuantity - soupQuantity) * GroceryProjectConstants.BREAD_COST + soupQuantity * GroceryProjectConstants.BREAD_COST/2;
				}else {
					billAmount += purchaseCart.get(GroceryProjectConstants.BREAD_PRODUCT) * (GroceryProjectConstants.BREAD_COST/2);
				}
			}else {
				billAmount += purchaseCart.get(GroceryProjectConstants.BREAD_PRODUCT) * GroceryProjectConstants.BREAD_COST;
			}
		}
		if(purchaseCart.containsKey(GroceryProjectConstants.MILK_PRODUCT)) {
			billAmount += purchaseCart.get(GroceryProjectConstants.MILK_PRODUCT) * GroceryProjectConstants.MILK_COST;
		}
		if(purchaseCart.containsKey(GroceryProjectConstants.APPLE_PRODUCT)) {
			if(date.isAfter(offer2ValidFrom) && date.isBefore(offer2ValidTo)) {
				double discountValue = purchaseCart.get(GroceryProjectConstants.APPLE_PRODUCT) * (   
						(GroceryProjectConstants.APPLE_COST * 10 /100));
				billAmount += purchaseCart.get(GroceryProjectConstants.APPLE_PRODUCT) * GroceryProjectConstants.APPLE_COST - discountValue;
			}else {
				billAmount += purchaseCart.get(GroceryProjectConstants.APPLE_PRODUCT) * GroceryProjectConstants.APPLE_COST;
			}
		}
		return billAmount;
	}
}
