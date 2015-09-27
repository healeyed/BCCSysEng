/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bccparkingpermitio;
import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author Ed Healey
 */
public class BCCParkingPermit {
    
    static double permitPrice = 100; // Standard permit price
    static double premiumCost = 25; // Additional premium cost if applicable
    static int discount = 25; // Discount pecentage if applicable
    
    /**
     * Prompts user for BCC permit outcode (number between 1 and 20) and quantity (number between 1 and 3)
     * appropriate checks made on input. User prompted to try again on each argument with guidance on fail.
     * On completion permit calculation is output to screen.
     * @param args values for outcode and quantity entered by user through console
     *
     */
    public static void main(String[] args) {
       InputStreamReader istream = new InputStreamReader(System.in) ;
       BufferedReader bufRead = new BufferedReader(istream) ; 
      
      boolean inputCheck = false; // Flag used pass or fail input based on validity checks
      String outcode = ""; // String variable used to store user input outcode - Should be number between 1 and 20
      String quantity = ""; // String variable used to store user input quantity - Should be number between 1 and 3
        // TODO code application logic here
    
    do { 
            try {
             System.out.println("Step 1. Enter your Bristol City postcode outcode number (eg. for BS8 type 8): ");
            
              outcode = bufRead.readLine();
             }
            catch (IOException err){
             System.out.println("Error reading line");
            }
                
             if (outcode.matches("\\d+")) { 
                  int i = Integer.parseInt(outcode);
                    if (checkIntRange(i,20)) {
                        inputCheck = true;
                    } 
                }
                
                if (!inputCheck){
                    System.out.format("Sorry,outcode has to be number from 1 to 20, you entered %s - try again\n",outcode);
                }
                  
               } while (!inputCheck);      
    
    inputCheck = false;        
    do {
           try {
              System.out.println("\nStep 2. Enter quantity (can be be between 1 - 3) : ");
              quantity = bufRead.readLine();
             }
            catch (IOException err){
             System.out.println("Error reading line");
            }
                
                if (quantity.matches("\\d+"))  {
                  int i = Integer.parseInt(quantity);
                    if (checkIntRange(i,3)) {
                        inputCheck= true;
                    }
                    
                }
                if (!inputCheck) {
                   System.out.format("Sorry,quantity has to be number from 1 to 3, you entered %s - try again",quantity); 
                }
               } while (!inputCheck);
            
            if (inputCheck){
                calculatePermit(Integer.parseInt(outcode),Integer.parseInt(quantity));      
            }
    
    
    }

/**
 * Returns the total discount on permits should any apply. 
 * 
 *
 * @param  q  is the quantity of permits requested
 * @param  totalprem the total premium applied (if any) 
 * @return The discount value 
 * 
 */    
static double calcDiscount(int q,double totalprem) {
   
    double pCost=0.0; 
    if (totalprem != 0.0){
        pCost=premiumCost;
    }
    double v = ((((q-1) * permitPrice) + (totalprem-pCost)) / 100) * discount;
    return v; 
}


/**
 * Outputs permit calculation to console. 
 * 
 *
 * @param  code  is the outcode
 * @param  q is the quantity
 * 
 */ 
static void  calculatePermit (int code, int q) {
        
        double totaliser = 0;
        double totalprem = 0;
        double v = 0;
        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK); 
        //System.out.printf("Price in GBP : %s %n", GBP.format();

        String fmt = "%-15s %11s" ;  
        String firstline = "\nYour caclulation for %s permits in area BS%s as follows:\n";
        String divider = "------------------------------\n";
        
        System.out.format(firstline,q,code);
        System.out.format(divider);
        
        for(int i=0; i<q; i++){
         System.out.format("%-6s %-7s %11s %n","Permit ",(i+1),GBP.format(permitPrice));
         totaliser = totaliser + permitPrice;
       }
        
        System.out.format(divider);
        
        if (checkIsPremiumCode(code)){
          totalprem = premiumCost * q;
          System.out.format("%n" + fmt + " (%s @ %s)%n","Plus premium",GBP.format(totalprem),q,GBP.format(premiumCost));
        }else{
          System.out.format("%n" + fmt + " (N/A)%n","Premium Total",GBP.format(0));
        }
        
        //double tDiscount = calcDiscount(q,totalprem);

        if (q > 1) {
          v = calcDiscount(q,totalprem);
          System.out.format(fmt + " (%s @ %s%%)%n","Less Discount",GBP.format(0-v),(q-1),discount);
        }else{
          System.out.format(fmt + " (N/A)%n","Less Discount",GBP.format(0)); 
        }
        totaliser = (totaliser - v) + totalprem;
        System.out.format(divider);
        System.out.format(fmt + "%n","Total Cost",GBP.format(totaliser));
        System.out.format(divider);
    }    
    
  /**
 * Checks if outcode is a premium address area
 * (Premium trigger can be 1 to 3 eg.BS1)
 *
 * @param  code  is the outcode
 * @return True or false
 * 
 */   
  static boolean checkIsPremiumCode(int code) {
     return checkIntRange(code,3);
  }   
    
   
  
    /**
 * Checks if number is within correct range
 * Number must not be 0
 *
 * @param  i number being checked
 * @param  max upper bound of range
 * @return True or false
 * 
 */
    static boolean checkIntRange (int i, int max) {
      boolean flag = false;
        if ((i <= max) && (i !=0)) {
            flag = true;
       }
        return flag;
    }
}
