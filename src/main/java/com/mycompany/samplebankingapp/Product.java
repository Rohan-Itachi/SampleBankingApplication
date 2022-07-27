
package com.mycompany.samplebankingapp;

public class Product {
    
  private int productNumber;
  private String productName;
  private double productPrice;
  
  public Product( int productNumber, String productName, double productPrice){
      this.productNumber = productNumber;
      this.productName = productName;
      this.productPrice = productPrice;
  
  };
  // getter methods
  public int getProductNumber(){
       return productNumber;
  }
  public String getProductName(){
      return productName;
  } 
  public double getProductPrice(){
        return productPrice;
  }
  
  // setter methods
  
  public void setProductNumber(int productNumber) {
      this.productNumber = productNumber;
  }
  
  public void setProductName( String productName ){
      this.productName = productName;
  }
  
  public void setProductPrice ( double productPrice) {
      this.productPrice = productPrice;
  }
 }
