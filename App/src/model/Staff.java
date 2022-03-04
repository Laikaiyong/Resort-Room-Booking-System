/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.nio.file.*;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author USER
 */
public class Staff {
    private static final String ALGORITHM = "AES";
    private static String KEY = "128BitRertrieval";// 128-bit retrieval
    // Store credentials
    public static void main(String[] args)
    {
        String username = "staff1234";
        String password = "stafflogin";
        String encryptedPass = "";
        StringBuilder encryptedPassword = new StringBuilder();
        try 
        {
            Key aesKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            
            // Encrypt password
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            for (byte b: encrypted) {
                encryptedPassword.append((char)b);
            }
            encryptedPass = encryptedPassword.toString();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
      
      File currentDir = new File("src/database/credentials.txt");
      Path fileName = Path.of(currentDir.getAbsolutePath());
      try 
      {
         Files.writeString(fileName, username + ", " + encryptedPass);
      } 
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      } 
    }
    
    private static String[] readCredentials()
    {
        String data = "";
        File currentDir = new File("src/database/credentials.txt");
        Path fileName = Path.of(currentDir.getAbsolutePath());
        if (currentDir.exists()) 
        {
            try {
                data = Files.readString(fileName);
            } catch(IOException ioe){
                ioe.printStackTrace();
            } 
         } else {
            System.out.println("The file does not exist.");
         }
        String[] credentials = data.split(", ");
        return credentials;
    }
    
    private static String decryptPassword(String pass)
    {
        //  Decrypt Password          
        byte[] bytePass = new byte[pass.length()];
        for (int i=0; i<pass.length(); i++) 
        {
            bytePass[i] = (byte) pass.charAt(i);
        }
        
        try 
        {
            Key aesKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(bytePass));
            return decrypted;
        } 
        catch (Exception e) 
        {
            return "Error";
        }
    }
    
    private final String username = readCredentials()[0];
    private final String password = decryptPassword(readCredentials()[1]);
    
    /* Methods
     * Getters
     */
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String toString()
    {
        return "Staff Credentials with username: " + username;
    }
}
