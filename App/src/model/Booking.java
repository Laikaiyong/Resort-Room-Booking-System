package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import java.util.*;

import controllers.CalculateDays;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

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
    private String status;
    private int stayDays;
    private LocalDate startDate;
    private LocalDate endDate;
    private String createdAt;
    private float pricePerNight;
    private float nightPay;
    private float serviceTax;
    private float tourismTax;
    private float finalPayment;
    private boolean addedCharges;
    private float addAmount;
    
    private static final File bookFile = new File("src/database/records.txt");
    
    private List<String> validStatus = new ArrayList<String>(
            Arrays.asList(
                    "Booked",
                    "Cancelled",
                    "CheckIn",
                    "CheckOut"
            )
    );

    private final CalculateDays calculator = new CalculateDays();
    
    /**
     * Constructor
     */
    public Booking(
            int recordId,
            String name, 
            String id,
            char newGender,
            String email,
            String room,
            String newStatus,
            LocalDate newStartDate,
            LocalDate newEndDate,
            String newCreatedAt,
            float extraCharges,
            boolean addedExtra
        )
    {
        bookingId = recordId;
        customerName = name;
        personalId = id;
        gender = newGender;
        customerEmail = email;
        roomId = room;
        status = newStatus;
        stayDays = calculator.dateDifference(newStartDate, newEndDate);
        startDate = newStartDate;
        endDate = newEndDate;
        createdAt = newCreatedAt;
        pricePerNight = 350f;
        nightPay = pricePerNight * stayDays;
        serviceTax = nightPay * 0.10f;
        tourismTax = stayDays * 10f;
        addAmount = extraCharges;
        finalPayment = nightPay + serviceTax + tourismTax + addAmount;
        addedCharges = addedExtra;
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
    
    public void setStatus(String status)
    {
        boolean validateStatus = validStatus.contains(status);
        if (validateStatus)
        {
            this.status = status;
        }
        else
        {
            System.out.println("Invalid status");
            JOptionPane.showMessageDialog(null, 
                                        "Invalid Booking Status",
                                        "Update Unsuccessful",
                                        JOptionPane.ERROR_MESSAGE);
        }
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
    
    public void setAddedCharges(float currency)
    {
        this.addedCharges = true;
        this.addAmount = currency;
        float temp = this.addAmount + this.nightPay;
        this.serviceTax = temp * 0.10f;
        this.finalPayment = this.addAmount + this.nightPay + this.serviceTax + this.tourismTax;
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
    
    public String getStatus()
    {
        return this.status;
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

    public String getCreatedTime()
    {
        return this.createdAt;
    }
    
    public float getNightPay()
    {
        return this.nightPay;
    }
    
    public float getTax()
    {
        return this.serviceTax + this.tourismTax;
    }
    
    public float getTotalPayment()
    {
        return this.finalPayment;
    }
    
    public float getExtraCharges()
    {
        return this.addAmount;
    }
    
    public boolean getAddedExtra()
    {
        return this.addedCharges;
    }
    
    @Override
    public String toString()
    {
        return "Booking " + bookingId + " on " + createdAt;
    }
}
