package com.facebook.dao;

import com.facebook.model.GenericEntity;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public abstract class GenericDao {

    protected abstract  List<GenericEntity> get(int n, String filePath) throws FileNotFoundException;

    public static int count(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        return lines;
    }

    public static void saveEntity(GenericEntity entity) {

        String filePath = entity.getStoragePath();
        String dataToSave = entity.toDataBaseFormat()+"\n";

        save(filePath, dataToSave, true);
    }

    public static void updateEntity(GenericEntity genericEntity) throws FileNotFoundException {
        String id = "" + genericEntity.getId();
        String filePath = genericEntity.getStoragePath();
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();

        String oldLine = "";
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            buffer.append(line + System.lineSeparator());
            if(line.startsWith(id + ";") ){
                oldLine = line;
            }
        }

        if(!oldLine.isEmpty()){
            String fileContents = buffer.toString();
            fileContents = fileContents.replace(oldLine, genericEntity.toDataBaseFormat());
            save(genericEntity.getStoragePath(), fileContents, false );
            System.out.println(String.format("Successfully updated entity with id '%s'.", id));
        } else {
            System.out.println(String.format("Could not update entity with id '%s' because it does not exist.", id));
        }
    }

    protected static void save(String filePath, String dataToSave, boolean append) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, append))) {
            pw.println(dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
