package Data_Module;
public class CartItem { 
    private final Product product;
    private int quantity;
    
    // Rep Invariant (RI):
    //  - Product must not be null.
    //  - quantity cannot go below zero(0).
    //
    // Abstraction Function (AF):
    //  - AF(product) = Obj of Product contains Product information.
    
   
    public CartItem(Product product, int quantity){
        
        this.product = product;
        this.quantity = quantity;
        checkRep();

    }

    /*
     * check RI
     */
    private void checkRep(){
        if((product == null) || (quantity < 0)){
            throw new RuntimeException("Rep invarint violent!");
        }
    }
    
    /**
     * 
     * @return quantity of puduct
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * 
     * @return price of the product
     */
    public double getPrice(){
        return product.getPrice();
    }

    /**
     * 
     * @return Product Object
     */
    public Product getProduct(){
        return product;
    }

    /**
     * 
     * @return ID of product
     */
    public String getID(){
        return product.getproductID();
    }

    


    
    /**
     * 
     * @param amount number of quantity that want to increase
     */
    public void increaseQuantity(int amount){

        quantity = quantity + amount;
        checkRep();

    }


}