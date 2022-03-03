package com.facebook.posts;

import com.facebook.generic.GenericEntity;
import com.facebook.generic.GenericRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostsRepository extends GenericRepository {

    @Override
    public List<GenericEntity> get(int n, String filePath) throws FileNotFoundException {
        List<GenericEntity> result = new ArrayList<>();

        Scanner sc = new Scanner(new File(filePath));
        int counter = 0;
        while (counter < n && sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] postAttributes = line.split(";");

            Post post = new Post(Integer.parseInt(postAttributes[0]), Integer.parseInt(postAttributes[1]), postAttributes[2],
                    Integer.parseInt(postAttributes[3]), Integer.parseInt(postAttributes[4]));

            result.add(post);
            counter++;
        }

        return result;
    }
}