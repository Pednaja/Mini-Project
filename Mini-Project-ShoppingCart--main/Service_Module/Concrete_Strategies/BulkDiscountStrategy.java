package Service_Module.Concrete_Strategies;

import Data_Module.CartItem;

public class BulkDiscountStrategy implements DiscountStrategy {

    private int minimium;
    private double percent;
     

    
    
    public BulkDiscountStrategy(int minimium,double percent){
        this.minimium = minimium;
        this.percent = percent;
    }
    
    public double calculatePrice(CartItem item) {
        double originalPrice = item.getProduct().getPrice() * item.getQuantity();
        if (item.getQuantity() >= minimium){
            return originalPrice * (1.0 - percent);
        }
        return originalPrice;
    }

   
    
}
