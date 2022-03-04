/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.File;
import java.nio.file.Path;
import model.Room;
/**
 *
 * @author USER
 */
public class RoomsConfig {
    public Room[] rooms = new Room[20];
    protected Room[] configRooms()
    {
        File currentDir = new File("src/database/room.txt");
        Path fileName = Path.of(currentDir.getAbsolutePath());
        return rooms;
    }
}
