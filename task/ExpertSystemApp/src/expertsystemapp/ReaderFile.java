/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Work
 */
public class ReaderFile {
    public static ArrayList<String> ReaderFile (String filePath){
        Scanner reader = null;
        ArrayList<String> output = new ArrayList<>();
        try {
            File fileObject = new File(filePath);
            reader = new Scanner(fileObject);
            while (reader.hasNextLine()) {
                String data = reader.nextLine().trim();
                if (!"".equals(data)){
                    output.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred."+e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        
        return output;
    }
}
