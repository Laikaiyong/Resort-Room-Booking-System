package model;

import java.util.*;
import javax.swing.JOptionPane;

public class Room {
    /**
     * Attributes
     */
    private String view;
    private String roomNumber;
    private String status;
    private boolean maintenance;
    private int paxForBed;
    
    private List<String> validStatus = new ArrayList<String>(
            Arrays.asList(
                    "Cleaning",
                    "Available",
                    "Occupied"
            )
    );
    
    public Room(
            String newView,
            String newRoomNo,
            String newStatus,
            boolean maintenanceStatus,
            int newPax
        )
    {
        view = newView;
        roomNumber = newRoomNo;
        status = newStatus;
        maintenance = maintenanceStatus;
        paxForBed = newPax;
    }
    
    /**
     * Setters
     */
    public void setView(String viewValue)
    {
        this.view = viewValue;
    }
    
    public void setRoomNumber(String roomNo)
    {
        this.roomNumber = roomNo;
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
            System.out.println("Invalid room status");
            JOptionPane.showMessageDialog(null, 
                                        "Invalid Room Status",
                                        "Update Unsuccessful",
                                        JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setMaintenance(boolean maintenance)
    {
        this.maintenance = maintenance;
    }

    public void setPax(int pax)
    {
        this.paxForBed = pax;
    }
    
    /**
     * Getters
     */
    public String getView()
    {
        return this.view;
    }

    public String getRoomNumber()
    {
        return this.roomNumber;
    }
    
    public String getRoomStatus()
    {
        return this.status;
    }
    
    public boolean getMaintenance()
    {
        return this.maintenance;
    }

    public int getPax()
    {
        return this.paxForBed;
    }
    
    /**
     * Room methods
     */
    public void checkIn()
    {
        this.status = "Checkin";
    }
    
    public void checkOut()
    {
        this.status = "Available";
    }
    
    public String toString()
    {
        return "Room Number " + roomNumber + " (" + view + ")";
    }
}
