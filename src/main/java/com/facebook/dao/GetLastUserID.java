package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetLastUserID {
    public static Integer getLastUserID() throws IOException {
        Path lastUserIDTable = Paths.get("src\\main\\resources", "LastUserIDTable.txt");
        String lastUserIDText = Files.readString(lastUserIDTable);
        return Integer.valueOf(lastUserIDText);
    }
}
