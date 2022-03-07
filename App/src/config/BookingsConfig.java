/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Booking;

/**
 *
 * @author USER
 */
public class BookingsConfig {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public ArrayList<Booking> bookings = configBooking();
    private ArrayList<Booking> configBooking()
    {
        ArrayList<Booking> bookingsRecord = new ArrayList<>();
        
        File file = new File("src/database/bookings.txt");
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
                            bookInformation[1],
                            bookInformation[2],
                            bookInformation[3].charAt(0),
                            bookInformation[4],
                            bookInformation[5],
                            bookInformation[6],
                            LocalDate.parse(bookInformation[8], dateFormatter),
                            LocalDate.parse(bookInformation[9], dateFormatter),
                            LocalDateTime.parse(bookInformation[10], datetimeFormatter)
                    );
                    bookingsRecord.add(newBooking);
                }
            }
        } 
        catch (IOException e)
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        return bookingsRecord;
    }
}
