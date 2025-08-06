package Service_Module;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import Data_Module.CartItem;
import Service_Module.Concrete_Strategies.*;

public class PricingService{
    
    private ArrayList<String> sku = new ArrayList<>();
    Dictionary<String, DiscountStrategy> strategies = new Hashtable<>();
    private DiscountStrategy defaultPricingStrategy = new DefaultPricingStrategy();

    // Rep Invariant (RI):
    //  - sku productID 
    //  - strategies Dicionary Dicionary sync productID with DiscountStrategy
    //  - defaultPricingStrategy DefaultStrategy for product that doesn't have DiscountStrategy
    // Abstraction Function (AF):
    //  - AF(sku, strategy) = sku productID ,strategies Dicionary sync productID with DiscountStrategy
  
    
    
    /**
     * 
     * @param sku ProductID
     * @param strategy DiscountStrategy Obj contain calculation of Strategy campain
     */
    public void addStrategy(String sku, DiscountStrategy strategy){
        
        if(this.sku.contains(sku)){
            strategies.remove(sku);
            strategies.put(sku, strategy);
        }
        else{
            strategies.put(sku, strategy);
        }
       
        }

     /**
      * 
      * @param item Obj product with quantity
      * @return double calculated price 
      */   
     public double calculateItemPrice(CartItem item){
        double price = 0;
        if(strategies.get(item.getID()) instanceof BogoDiscountStrategy){
            price = strategies.get(item.getID()).calculatePrice(item);
        }
        else if(strategies.get(item.getID()) instanceof BulkDiscountStrategy){
            price = strategies.get(item.getID()).calculatePrice(item);
        }
        else{
            price = defaultPricingStrategy.calculatePrice(item);
        }

        return price;



     }

   
}