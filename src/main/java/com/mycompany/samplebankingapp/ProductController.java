
package com.mycompany.samplebankingapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ArrayList <Product> products = new ArrayList<>();
    DbConnection db = new DbConnection();
    
    // adds a product 
    public boolean addProduct( int productNumber, String productName, double productPrice) {
        
        
        
        
        if(findProduct(productNumber) == null)
        { 
            String sql = "INSERT INTO `test_db`.`product` (`idnew_table`, `product_name`, `product_price`) VALUES ('" + productNumber + "', '" + productName + "', '" + productPrice + "');";
            return db.iud(sql);
           
        }

        return false; 
    }
    // find a product
    public Product findProduct(int productNumber){
        
        String sql = "select * from test_db.product where idnew_table=" + productNumber + ";";
        ResultSet rs = db.select(sql);
        
         try {
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                Product acc = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                return acc;
            }
        } catch (SQLException e) {
            return null;
        }
        
//        for(Product pro : products) {
//            if(pro.getProductNumber() == productNumber){
//                return pro;
//            }
//        }
        
        return null;
        
    }
    
    // product check
    
    public void checkProduct(int productNumber) {
    if(findProduct(productNumber) != null){
    Product pro = findProduct(productNumber);
    System.out.print("Product is:"+ pro.getProductName());
    } else {
    System.out.println("Invalid product Number or product does not exist");
        }
  }
   // list all products
    
    public ArrayList<Product> listAllProduct(){
        return products;
    }
    
    // delete a product
    
   public boolean deleteProduct(int productNumber){ 
       if(findProduct(productNumber) != null){
           Product pro = findProduct(productNumber);
           products.remove(pro);
           return true;
       }
       return false;
   }
    
    
}
