/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Booking;

/**
 *
 * @author USER
 */
public class BookingController {
    public void updateBookingDatabase(ArrayList<Booking> list)
    {
        System.out.println("Updating Bookimg database");
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
                        "%s, %s, %s, %c, %s, %s, %s, %d, %s, %s, %s, %f, %f, %f, %b\n",
                        record.getBookingId(),
                        record.getCustomer().getName(),
                        record.getCustomer().getPersonalId(),
                        record.getCustomer().getGender(),
                        record.getCustomer().getEmail(),
                        record.getBookedRoom(),
                        record.getStatus(),
                        record.getStayDays(),
                        record.getStartDate().toString(),
                        record.getEndDate().toString(),
                        record.getCreatedTime(),
                        record.getNightPay(),
                        record.getExtraCharges(),
                        record.getTotalTax(),
                        record.getAddedExtra()
                    )
                );
                item++;
            }
            printWriter.close();
        }
        catch(IOException e)
        {
        };
    }
}
