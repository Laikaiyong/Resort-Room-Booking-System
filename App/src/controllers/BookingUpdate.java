/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import model.Booking;

/**
 *
 * @author USER
 */
public class BookingUpdate {
    public void updateBookingDatabase(ArrayList<Booking> list)
    {
        File file = new File("src/database/records.txt");
        try
        {
            System.out.println("Updating file");
            PrintWriter printWriter = new PrintWriter(new FileWriter(file, false));
            printWriter.flush();
            int item = 1;
            for (Booking record: list)
            {
                printWriter.append(
                    String.format(
                        "%d, %s, %s, %c, %s, %s, %s, %d, %s, %s, %s\n",
                        record.getBookingId(),
                        record.getCustomerName(),
                        record.getPersonalId(),
                        record.getGender(),
                        record.getCustomerEmail(),
                        record.getBookedRoom(),
                        record.getStatus(),
                        record.getStayDays(),
                        record.getStartDate().toString(),
                        record.getEndDate().toString(),
                        record.getCreatedTime().toString()
                    )
                );
                item++;
            }
            printWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
    }    
}
