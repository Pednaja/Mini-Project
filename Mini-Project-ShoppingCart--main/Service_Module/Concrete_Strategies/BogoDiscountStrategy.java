package Service_Module.Concrete_Strategies;

import Data_Module.CartItem;

public class BogoDiscountStrategy implements DiscountStrategy {
    
    
    @Override
   public double calculatePrice(CartItem item) {
     
        return item.getPrice() * ((item.getQuantity()/2) + (item.getQuantity() %2));


    
    }
}
