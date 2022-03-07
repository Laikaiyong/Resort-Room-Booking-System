/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.IOException; 
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import model.Room;
/**
 *
 * @author USER
 */
public class RoomsConfig {
    public ArrayList<Room> rooms = configRooms();
    
    private static String[] VIEWS = {"Jungle", "River"};
    private static int MAX_ROOM = 20;
    private static int MAX_EACH = 10;
    
    public static void main(String[] args)
    {
        RoomsConfig initializer = new RoomsConfig();
    }
    
    private ArrayList<Room> configRooms()
    {
        ArrayList<Room> rooms = new ArrayList<Room>(MAX_ROOM);
        
        File file = new File("src/database/room.txt");
        Path filePath = Path.of(file.getAbsolutePath());
        // Create file / Retrive data from file
        try 
        {
            //  Initialization   
            if (file.createNewFile()) 
            {
                System.out.println("File creating.");
                PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
                for (int roomIndex = 0; roomIndex < MAX_ROOM; roomIndex++)
                {
                    if (roomIndex < MAX_EACH)
                    {
                        Room newRoom = new Room(
                            VIEWS[0],
                            "J" + String.format("%02d", roomIndex + 1),
                            "Available",
                            false,
                            (roomIndex < 5) ? 2 : 4
                        );
                        rooms.add(newRoom);
                        printWriter.append(
                                String.format(
                                        "%s, %s, %s, %b, %d\n",
                                        newRoom.getView(),
                                        newRoom.getRoomNumber(),
                                        newRoom.getRoomStatus(),
                                        newRoom.getMaintenance(),
                                        newRoom.getPax()
                                )
                        );
                    }
                    else
                    {
                        Room newRoom = new Room(
                            VIEWS[1],
                            "R" + String.format("%02d", roomIndex + 1 - 10),
                            "Available",
                            false,
                            ((roomIndex - 10) < 5) ? 2 : 4
                        );
                        rooms.add(newRoom);
                        if (roomIndex == MAX_ROOM - 1)
                        {
                            printWriter.append(
                                String.format(
                                        "%s, %s, %s, %b, %d",
                                        newRoom.getView(),
                                        newRoom.getRoomNumber(),
                                        newRoom.getRoomStatus(),
                                        newRoom.getMaintenance(),
                                        newRoom.getPax()
                                )
                            );
                            break;
                        }
                        printWriter.append(
                                String.format(
                                        "%s, %s, %s, %b, %d\n",
                                        newRoom.getView(),
                                        newRoom.getRoomNumber(),
                                        newRoom.getRoomStatus(),
                                        newRoom.getMaintenance(),
                                        newRoom.getPax()
                                )
                        );
                    }
                }
                printWriter.close();
            }
            //  Read file to get rooms          
            else
            {
                System.out.println("File already exists.");
                Scanner input = new Scanner(file);
                while(input.hasNextLine()){
                    String line = input.nextLine();
                    String[] roomInformation = line.split(", ");
                    Room newRoom = new Room(
                            roomInformation[0],
                            roomInformation[1],
                            roomInformation[2],
                            Boolean.parseBoolean(roomInformation[3]),
                            Integer.parseInt(roomInformation[4])
                    );
                    rooms.add(newRoom);
                }
            }
        } 
        catch (IOException e)
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        return rooms;
    }
}
