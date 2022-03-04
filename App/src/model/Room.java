package model;

public class Room {
    /**
     * Attributes
     */
    private String view;
    private String roomNumber;
    private String status;
    private boolean maintenance;
    private int paxForBed;
    
    public Room(){ }
    
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
        this.status = status;
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
