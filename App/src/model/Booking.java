package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;

import controllers.CalculateDays;

public class Booking {
    /**
     * Attributes
     */
    private int bookingId;
    private String customerName;
    private String personalId;
    private char gender;
    private String customerEmail;
    private String roomId;
    private int stayDays;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;

    protected final float chargePerNight = 350f;
    protected final Currency malaysiaRM = Currency.getInstance("MYS");

    CalculateDays calculator = new CalculateDays();
    
    /**
     * Constructor
     */
    public Booking(
            String name, 
            String id,
            char newGender,
            String email,
            String roomId,
            LocalDate newStartDate,
            LocalDate newEndDate,
            LocalDateTime newCreatedAt
        )
    {
        customerName = name;
        personalId = id;
        gender = newGender;
        customerEmail = email;
        stayDays = calculator.dateDifference(startDate, endDate);
        startDate = newStartDate;
        endDate = newEndDate;
        createdAt = newCreatedAt;
    }
    
    /**
     * Setters
     */
    public void setBookingId(int requestNum)
    {
        this.bookingId = requestNum;
    }
    
    public void setCustomerName(String name)
    {
        this.customerName = name;
    }

    public void setICPassport(String id)
    {
        this.personalId = id;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }
    
    public void setEmail(String email)
    {
        this.customerEmail = email;
    }
    
    public void setRoom(String roomId)
    {
        this.roomId = roomId;
    }
    
    public void setStartDate(LocalDate start)
    {
        this.startDate = start;
        this.stayDays = calculator.dateDifference(this.startDate, this.endDate);
    }

    public void setEndDate(LocalDate end)
    {
        this.endDate = end;
        this.stayDays = calculator.dateDifference(this.startDate, this.endDate);
    }

    /**
     * Getters
     */
    public int getBookingId()
    {
        return this.bookingId;
    }

    public String getCustomerName()
    {
        return this.customerName;
    }

    public String getPersonalId()
    {
        return this.personalId;
    }

    public char getGender()
    {
        return this.gender;
    }

    public String getCustomerEmail()
    {
        return this.customerEmail;
    }

    public String getBookedRoom()
    {
        return this.roomId;
    }

    public int getStayDays()
    {
        return this.stayDays;
    }

    public LocalDate getStartDate()
    {
        return this.startDate;
    }

    public LocalDate getEndDate()
    {
        return this.endDate;
    }

    public LocalDateTime getCreatedTime()
    {
        return this.createdAt;
    }
}
