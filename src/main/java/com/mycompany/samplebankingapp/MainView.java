
package com.mycompany.samplebankingapp;
import java.util.Scanner;

public class MainView {
    
    static public Scanner sc = new Scanner(System.in);
    static UserController uc = new UserController();
    static ProductController pc = new ProductController();
    
    public static void main (String[] args) {
      // Start/run the application
        boolean exit = false;
        do {
            if(loginView()){
              int ch;
            do {
             // User instruction
             System.out.println("Welcome !!!");
             System.out.println("******");
             System.out.println("1) Add User");
             System.out.println("2) Delete User");
             System.out.println("3) Add Product");
             System.out.println("4) list all Products");
             System.out.println("5) Delete a product");
             System.out.println("6) View a single product");
             System.out.println("******");
             System.out.println("Enter appropriate choice");
             System.out.print("Enter 0 to logout");
             ch = sc.nextInt();
             switch(ch){
                 case 0:
                     break;
                 case 1:
                     addUserView();
                     break;
                 case 2:
                     deleteUserView();
                     break;
                 case 3:
                     addProductView();
                     break;
                 case 4:
                     listAllProductsView();
                     break;
                 case 5:
                     deleteProductView();
                     break;
                 case 6:
                     getSingleProductView();
                 default:
                     System.out.println("enter appropriate response");
             }
             
            } while(ch!=0);
            
            }
            
            System.out.println("Enter 1 to relogin and 0 exit");
            int p = sc.nextInt();
            if(p!=1){
            exit = true;
            }
            
        } while(!exit);
        
    }
    
    // Login view 
    
     public static boolean loginView() {
    System.out.println("Enter username");
    
    String userName = sc.next();
    
     System.out.println("Enter password");
     String passWord = sc.next();
     return uc.login(userName, passWord);
     
    }
    //  add user views
    
    public static void addUserView() {
      System.out.println("Login again to add user");
      
      if(loginView()){
          System.out.println("Enter a new username");
          String userName = sc.next();
          System.out.println("Enter a new password");
          String passWord = sc.next();
          System.out.println("Retype your new password");
          String temp = sc.next();
          // check both passwords
          
          if( passWord.equals(temp)){
              // call add user controller
              if(uc.addUser(userName, passWord)){
              System.out.println("User added Successfully");
              } else {
                  System.out.println("User already exist");
              }
          } else {
              System.out.println("password did not match");
          }
      } else {
          System.out.println("Invalid login credential");
      }
    
    }
    
    // delete user
    
    public static void deleteUserView() {
    
        System.out.println("Login again to delete a user");
        if(loginView()){
            System.out.println("Enter username to delete");
            String userName = sc.next();
            
            if(uc.deleteUser(userName)){
                System.out.println("User deleted");
            } else {
                System.out.println("Username doesn't exit");
            }
        }
        
    }
    
    // Add a product 
    
    public static void addProductView(){
        System.out.println("Enter product Number");
        int productNumber = sc.nextInt();
        System.out.println("Enter product Name");
        String productName = sc.next();
        System.out.println("Enter product Price");
        double productPrice = sc.nextDouble();
        if(pc.addProduct(productNumber, productName, productPrice)){
           System.out.println("Producted added successfully");
        } else {
            System.out.println("Product already exist");
                    
        }
        
        
    }
    
    public static void listAllProductsView(){
        for(Product pro :  pc.listAllProduct()){
          System.out.println(pro.getProductNumber()+"       "+pro.getProductName()+"    "+pro.getProductPrice());
      }
    }
    
  
    
    public static void deleteProductView(){
        System.out.println("Enter product number to delete");
        int prodNo = sc.nextInt();
        if(pc.deleteProduct(prodNo)){
        System.out.println("product deleted");
        } else {
            System.out.println("Enter valid product number");
        }
        
    }
    
    public static void getSingleProductView(){
        System.out.println("Enter a product Number");
        int prodNo = sc.nextInt();
        pc.checkProduct(prodNo);
        
    }
    
}
