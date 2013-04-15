/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

/**
 *
 * @author Di Wang
 */
public class Order 
{
    private String clientName;
    private String PID;
    private int Quantity;
    
    public Order(String name, String id, int quantity)
    {
        clientName = name;
        PID = id;
        Quantity = quantity;
    }
    
    public String getName()
    {
        return clientName;
    }
    
    public String getPID()
    {
        return PID;
    }
    
    public int getQuantity()
    {
        return Quantity;
    }
    
}
