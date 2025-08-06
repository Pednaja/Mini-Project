package Data_Module;

import javax.management.RuntimeErrorException;

public final class Product {
    private final String productID;
    private final String productName;
    private final double price;

    // Rep Invariant (RI):
    //  - productID must not be null or blank or emthy
    //  - productName must not be null or blank or emthy
    //  - product must be positive 
    // Abstraction Function (AF):
    //  - AF(productID) = ID of the product
    //  - AF(productName) = Name of the product
    //  - AF(price) = price of the product
    

    public Product(String productID, String productName, double price){

        this.productID = productID;
        this.productName = productName;
        this.price = price;
        checkRep();

    }

    /**
     * check RI
     */
    private void checkRep(){
        if((productID == null) || (productID == " ") || (productName.isBlank())){
            throw new RuntimeException("Rep invariant violated!");

        }


        if((productName == null) || (productName == " ") || (productName.isBlank())){
            throw new RuntimeException("Rep invariant violated!");
        }

        if(price < 0){
            throw new RuntimeException("Rep invariant violated!");
        }


    }

    /**
     * 
     * @param product 
     * @return true if productID are equal , false if not equal
     */
    public boolean equals(Product product){

        if(product.productID == this.productID){
            return true;
        }
        else{
        return false;
        }

    }
    
    /**
     * 
     * @return product price
     */
    public double getPrice(){
        return this.price;
    }
    
    /**
     * 
     * @return product name
     */
    public String getproductName(){
        return this.productName;
    }
    
    /**
     * 
     * @return product ID
     */
    public String getproductID(){
        return this.productID;
    }


    
    
}
