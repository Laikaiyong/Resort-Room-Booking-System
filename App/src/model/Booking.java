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
    private LocalDateTime createdAt;
    
    private static final File bookFile = new File("src/database/records.txt");
    private static int totalRecord = (int) lineTotal(bookFile);
    
    private List<String> validStatus = new ArrayList<String>(
            Arrays.asList(
                    "Booked",
                    "Cancelled",
                    "CheckIn",
                    "CheckOut"
            )
    );

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
            String room,
            String newStatus,
            LocalDate newStartDate,
            LocalDate newEndDate,
            LocalDateTime newCreatedAt
        )
    {
        bookingId = totalRecord + 1;
        customerName = name;
        personalId = id;
        gender = newGender;
        customerEmail = email;
        roomId = room;
        status = newStatus;
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

    public LocalDateTime getCreatedTime()
    {
        return this.createdAt;
    }
    
    public static long lineTotal(File file)
    {
        long lines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file)))
        {
            while (lnr.readLine() != null)
            {
                lines = lnr.getLineNumber();   
            }
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return lines;
    }
    
    public String toString()
    {
        return "Booking " + bookingId + " on " + createdAt;
    }
}
