package config;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Booking;

public class BookingsConfig {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public ArrayList<Booking> bookings = configBooking();
    private ArrayList<Booking> configBooking()
    {
        ArrayList<Booking> bookingsRecord = new ArrayList<>();
        
        File file = new File("src/database/records.txt");
        // Create file / Retrive data from file
        try 
        {
            //  Initialization   
            if (file.createNewFile()) 
            {
                System.out.println("Empty file creating.");
            }
            //  Read file to get rooms          
            else
            {
                System.out.println("Record file exists.");
                Scanner input = new Scanner(file);
                while(input.hasNextLine()){
                    String line = input.nextLine();
                    String[] bookInformation = line.split(", ");
                    Booking newBooking = new Booking(
                            bookInformation[0],
                            bookInformation[1],
                            bookInformation[2],
                            bookInformation[3].charAt(0),
                            bookInformation[4],
                            bookInformation[5],
                            bookInformation[6],
                            bookInformation[7],
                            LocalDate.parse(bookInformation[9], dateFormatter),
                            LocalDate.parse(bookInformation[10], dateFormatter),
                            bookInformation[11],
                            Float.parseFloat(bookInformation[13]),
                            Boolean.parseBoolean(bookInformation[15])
                    );
                    bookingsRecord.add(newBooking);
                }
            }
        } 
        catch (IOException e)
        {
          System.out.println("Booking record cannot be sent to database.");
        }
        
        return bookingsRecord;
    }
}
