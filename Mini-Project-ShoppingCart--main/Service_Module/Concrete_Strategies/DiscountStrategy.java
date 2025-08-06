package Service_Module.Concrete_Strategies;

import Data_Module.CartItem;

public interface DiscountStrategy {

    public double calculatePrice(CartItem item);
    

    

}
