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
import model.Room;

/**
 *
 * @author USER
 */
public class RoomsUpdate {
    public void updateRoomDatabase(ArrayList<Room> list)
    {
        File file = new File("src/database/room.txt");
        Path filePath = Path.of(file.getAbsolutePath());
        try
        {
            System.out.println("Updating file");
            PrintWriter printWriter = new PrintWriter(new FileWriter(file, false));
            printWriter.flush();
            int item = 1;
            for (Room room: list)
            {
                if(item == 20)
                {
                    printWriter.append(
                        String.format(
                            "%s, %s, %s, %b, %d",
                            room.getView(),
                            room.getRoomNumber(),
                            room.getRoomStatus(),
                            room.getMaintenance(),
                            room.getPax()
                        )
                    );
                    break;
                }
                printWriter.append(
                    String.format(
                        "%s, %s, %s, %b, %d\n",
                        room.getView(),
                        room.getRoomNumber(),
                        room.getRoomStatus(),
                        room.getMaintenance(),
                        room.getPax()
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
