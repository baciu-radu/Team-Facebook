package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetCurrentUserID {
    public String getCurrentUserID() throws IOException {
        Path currentUserIDTable = Paths.get("src\\main\\resources", "CurrentUserIDTable.txt");
        String currentUserIDText = Files.readString(currentUserIDTable);

        return currentUserIDText;
    }
}
