import java.util.ArrayList;

import Data_Module.CartItem;
import Data_Module.Product;
import Service_Module.PricingService;
import Service_Module.ProductCatalog;

public class ShoppingCart {
    ArrayList<CartItem> cartItems;
    PricingService pricingService = new PricingService();
    ProductCatalog productCatalog = new ProductCatalog();

     // Rep Invariant (RI):
    //  -Arraylist in cartItems must not be null
    //  -must not have duplicate Product in Arraylist of cartItem
    //
    // Abstraction Function (AF):
    //  - AF(cartItems) = Arraylist of Product with quantity
    //  - AF(pricingService) = Class contains ProductID sync with DiscountStrategy
    //  - AF(productCatalog) = Catalog of product contains Name of product
    
    /**
     * constructor set pricingService and productCatalog and create new cartItems Arraylist
     * @param pricingService 
     * @param productCatalog
     */
    public ShoppingCart(PricingService pricingService , ProductCatalog productCatalog){
        this.cartItems = new ArrayList<>();
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
    }

    /**
     * check RI
     */
    private void checkRep(){
        for(int i = 0 ; i < cartItems.size() ; i++){
            if(cartItems.get(i) == null){
                throw new RuntimeException("Rep invariant violated!");
            }
            for(int j = i+1 ; j < cartItems.size() ; j++){
                if(cartItems.get(i).getID().equals(cartItems.get(j).getID())){
                    throw new RuntimeException("Rep invariant violated!");
                }
            }
        }
    }

    
    /**
     * add Item to shopping cartItems
     * @param productId
     * @param quantity
     */
    public void addItem(String productId, int quantity) {
        if (quantity <= 0) return;

        Product product = productCatalog.findById(productId);
        if (product == null) return;

        for (CartItem item : cartItems) {
            if (item.getID().equals(productId)) {
                item.increaseQuantity(quantity);
                checkRep();
                return;
            }
        }

        cartItems.add(new CartItem(product, quantity));
        checkRep();
        
    }
    

    /**
     * remove Item form cartItems
     * @param productID
     */
    public void removeItem(String productID){
        for(int i = 0 ; i < cartItems.size() ; i++){
            if(cartItems.get(i).getID().equals(productID)){
                cartItems.remove(i);
            }
            checkRep();
        }
    }

    /**
     * 
     * @return number of type of Product in cartItems
     */
    public int getItemCount(){

        return this.cartItems.size();

    }

    /**
     * remove all Product in CartItems
     */
    public void clearCart(){
        cartItems.clear();
    }

    /**
     * calculate price of every Product in cartItems
     * @return sum contains Calculated price of every Items in cartItems
     */
    public double getTotalPrice(){
        double sum = 0;
        for(int i = 0 ; i < cartItems.size() ; i++){
            sum =  sum + pricingService.calculateItemPrice(cartItems.get(i));
        }

        return sum;

    } 
}
