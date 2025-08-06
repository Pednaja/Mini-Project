package Service_Module;
import Data_Module.*;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> product = new ArrayList<>();

    // Rep Invariant (RI):
    //  - product Arraylist of product in the store

   
 
   
    /**
     * check RI
     */
    private void checkRep(){
 
            if((product == null)){
                throw new RuntimeException("Rep invariant violated!");
            }
        

        for(int i = 0 ; i < product.size() ; i++){
            for(int j = i+1 ; j < product.size() ; j++){
                if(product.get(i).equals(product.get(j))){
                    throw new RuntimeException("Rep invariant violated!");
                }
            } 
        }
    }
    
    /**
     * 
     * @param product obj that going to add in Catalog
     */
    public void addProduct(Product product){
        if((product != null) && !(this.product.contains(product)))
        this.product.add(product);
        checkRep();

    }

    /**
     * 
     * @param productID 
     * @return Product Obj 
     */
    public Product findById(String productID){
        
        for(int i = 0 ; i < product.size() ; i++){
            if(this.product.get(i).getproductID().equals(productID)){
                return this.product.get(i);
            }

        }

        return null;

        
        
    }

}
