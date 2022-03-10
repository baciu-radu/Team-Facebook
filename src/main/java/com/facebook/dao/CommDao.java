package com.facebook.dao;

import com.facebook.model.GenericEntity;
import com.facebook.model.Comment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CommDao extends GenericDao {
    @Override
    protected List<GenericEntity> get(int n, String filePath) {
        return Collections.emptyList();
    }

    public static List<Comment> getCommentsForPost(int postId) throws FileNotFoundException {
        List<Comment> result = new ArrayList<>();

        Scanner sc = new Scanner(new File(Comment.COMM_REPOSITORY_PATH));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.contains(";" + postId + ";")) {
                String[] commAttributes = line.split(";");
                result.add(new Comment(postId, commAttributes[2]));
            }
        }

        return result;
    }
}
