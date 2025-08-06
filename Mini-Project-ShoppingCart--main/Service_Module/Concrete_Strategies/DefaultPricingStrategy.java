package Service_Module.Concrete_Strategies;

import Data_Module.CartItem;

public class DefaultPricingStrategy implements DiscountStrategy {

   
    @Override
    public double calculatePrice(CartItem item) {


        return item.getPrice()*item.getQuantity();
    }
    
}
