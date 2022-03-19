package com.facebook.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModifyProfile {
    public static void modifyProfile( String oldValue, String newValue){
        Path filePath = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            File fileToBeModified= new File(String.valueOf(filePath));
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();
//            System.err.println(line);

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
//                System.err.println(line);
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldValue, newValue);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}

