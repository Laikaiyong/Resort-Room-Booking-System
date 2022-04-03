package model;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.*;

import controllers.CalculateDays;

public class Booking {
    /**
     * Attributes
     */
    private String bookingId;
    private Customer bookingCustomer;
    private String roomId;
    private String status;
    private int stayDays;
    private LocalDate startDate;
    private LocalDate endDate;
    private final String createdAt;
    private float nightPay;
    private float serviceTax;
    private float tourismTax;
    private float finalPayment;
    private boolean addedCharges;
    private float addAmount;
    private final static float PRICE_PER_NIGHT = 350f;
    
    /**
     * Validated Status
     */
    private static final List<String> validStatus = new ArrayList<>(
            Arrays.asList(
                    "Booked",
                    "CheckIn",
                    "CheckOut"
            )
    );

    private static final CalculateDays calculator = new CalculateDays();
    
    /**
     * Constructor for Data Reading
     * @param recordId
     * @param name
     * @param id
     * @param newGender
     * @param email
     * @param contactNumber
     * @param room
     * @param newStatus
     * @param newStartDate
     * @param newEndDate
     * @param newCreatedAt
     * @param extraCharges
     * @param addedExtra
     */
    public Booking(
            String recordId,
            String name, 
            String id,
            char newGender,
            String email,
            String contactNumber,
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
        bookingCustomer = new Customer(
                name, 
                id, 
                newGender, 
                email,
                contactNumber
        );
        roomId = room;
        status = newStatus;
        stayDays = calculator.dateDifference(newStartDate, newEndDate);
        startDate = newStartDate;
        endDate = newEndDate;
        createdAt = newCreatedAt;
        nightPay = PRICE_PER_NIGHT * stayDays;
        serviceTax = nightPay * 0.10f;
        tourismTax = stayDays * 10f;
        addAmount = extraCharges;
        finalPayment = nightPay + serviceTax + tourismTax + addAmount;
        addedCharges = addedExtra;
    }
    
    /**
     * Constructor for New Booking
     * @param recordId
     * @param newCustomer
     * @param room
     * @param newStatus
     * @param newStartDate
     * @param newEndDate
     * @param newCreatedAt
     * @param extraCharges
     * @param addedExtra
     */
    public Booking(
            String recordId,
            Customer newCustomer,
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
        bookingCustomer = newCustomer;
        roomId = room;
        status = newStatus;
        stayDays = calculator.dateDifference(newStartDate, newEndDate);
        startDate = newStartDate;
        endDate = newEndDate;
        createdAt = newCreatedAt;
        nightPay = PRICE_PER_NIGHT * stayDays;
        serviceTax = nightPay * 0.10f;
        tourismTax = stayDays * 10f;
        addAmount = extraCharges;
        finalPayment = nightPay + serviceTax + tourismTax + addAmount;
        addedCharges = addedExtra; 
    }
    
    /**
     * Setters
     */
    public void setBookingId(String requestNum)
    {
        this.bookingId = requestNum;
    }
    
    public void setCustomer(Customer editedCustomer)
    {
        this.bookingCustomer = editedCustomer;
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
    public String getBookingId()
    {
        return this.bookingId;
    }

    public Customer getCustomer()
    {
        return this.bookingCustomer;
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
    
    public float getServiceTax()
    {
        return this.serviceTax;
    }
    
    public float getTourismTax()
    {
        return this.tourismTax;
    }
    
    public float getTotalTax()
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
    
    // Display when object being printed
    @Override
    public String toString()
    {
        return "Booking " + bookingId + " on " + createdAt;
    }
}
