package model;

public class Customer
{
    /**
     * Attributes
     */
    private String name;
    private String personalId;
    private char gender;
    private String email;
    private String contactNumber;
    
    /**
    * Constructor
    * For new Booking Request
    */
    public Customer()
    {
        name = "";
        personalId = "";
        gender = '-';
        email = "";
        contactNumber = "";
    }

    /**
    * Constructor
    * For existing Booking Request from Data Reading
     * @param newName
     * @param newPersonalId
     * @param newGender
     * @param newEmail
     * @param newContactNumber
    */
    public Customer(
            String newName, 
            String newPersonalId, 
            char newGender, 
            String newEmail,
            String newContactNumber
    )
    {
        this.name = newName;
        this.personalId = newPersonalId;
        this.gender = newGender;
        this.email = newEmail;
        this.contactNumber = newContactNumber;
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
    
    public void setContactNumber(String phoneNumber)
    {
        this.contactNumber = phoneNumber;
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
        
    public String getContactNumber()
    {
        return this.contactNumber;
    }
    
    // Display message when printed
    @Override
    public String toString()
    {
        return "Customer " + name + " (" + personalId + ")";
    }
}
