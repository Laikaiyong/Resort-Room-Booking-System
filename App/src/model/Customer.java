/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public class Customer
{
    private String name;
    private String personalId;
    private char gender;
    private String email;
    
    /*
    * Constructors
    */
    public Customer()
    {
        name = "";
        personalId = "";
        gender = '-';
        email = "";
    }

    public Customer(
            String newName, 
            String newPersonalId, 
            char newGender, 
            String newEmail
    )
    {
        this.name = newName;
        this.personalId = newPersonalId;
        this.gender = newGender;
        this.email = newEmail;
    }
    
    /*
    * Setters
    */
    public void setName(String customerName)
    {
        this.name = customerName;
    }
    
    public void setPersonalId(String customerPersonalId)
    {
        this.personalId = customerPersonalId;
    }
    
    public void setGender(char customerGender)
    {
        this.gender = customerGender;
    }
    
    public void setEmail(String customerEmail)
    {
        this.email = customerEmail;
    }
    
    /*
    * Getters
    */
    public String getName()
    {
        return this.name;
    }
    
    public String getPersonalId()
    {
        return this.personalId;
    }
    
    public char getGender()
    {
        return this.gender;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    // Display message when printed
    @Override
    public String toString()
    {
        return "Customer " + name + " (" + personalId + ")";
    }
}
