/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

/**
 *
 * @author Di Wangs
 */
public class Order 
{
    private String clientName;
    private String PID;
    private double PRICE;
    private double TOTAL_PRICE;
    private String TITLE;
    private int Quantity;
    public Order (){
        clientName = "";
        PID = "";
        Quantity = 0;
        PRICE = 0.0;
        TOTAL_PRICE = 0.0;
    }
    public Order(String name,String id, String title, int quantity,double price)
    {
        clientName = name;
        PID = id;
        TITLE = title;
        Quantity = quantity;
        PRICE = price;
        TOTAL_PRICE = Quantity*PRICE;
    }
    
    public double getTotalPrice()
    {
        return TOTAL_PRICE;
    }
    
    public String getName()
    {
        return clientName;
    }
    
    public String getPID()
    {
        return PID;
    }
    
    public double getPrice()
    {
        return PRICE;
    }
    
    public String getTitle()
    {
        return TITLE;
    }
    
    public int getQuantity()
    {
        return Quantity;
    }
    
    @Override
    public String toString(){
        return clientName + PID + Quantity;
    }
    
}
