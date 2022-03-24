package com.facebook.model;

import com.facebook.dao.CommDao;
import com.facebook.dao.GenericDao;
import com.facebook.dao.PostDao;
import com.facebook.ui.HomeUI;
import com.facebook.ui.LoadingUI;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HomePage {



    public void newsFeed() throws IOException, InterruptedException, AWTException {
        HomeUI homeUI = new HomeUI();
        LoadingUI loadingUI = new LoadingUI();
        int n = 5;
        PostDao postsDao = new PostDao();
        java.util.List<GenericEntity> newsFeed = postsDao.get(n, Post.POST_REPOSITORY_PATH);

        int i = 1;
        for (GenericEntity post : newsFeed) {
            System.out.print(i + ". ");
            System.out.println(post);
            System.out.println("Like or Comment");

            List<Comment> postComments = CommDao.getCommentsForPost(post.getId());
            for (Comment c : postComments) {
                System.out.println("\t -" + c);
            }
            System.out.println();
            i++;
        }

        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please indicate the number of the Post that you wish to Like or Comment or press '0' to return to Home Page ");
        int postNr = in.nextInt();
        if (postNr == 0) {
            loadingUI.popProgressBar();
            homeUI.showHomeUI();
        }
        if (postNr < 1 || postNr > n) {
            System.err.println("The post " + postNr + " doesn't exist. Please choose another post!\n");
            newsFeed();
        }
        System.out.println("Now please choose which action you want to perform for the selected post: 1 for Like, 2 for Comment: ");
        int actionNr = in.nextInt();
        while (actionNr != 1 && actionNr != 2) {
            System.err.println("Invalid action. Please try again");
            System.out.println("Now please choose which action you want to perform for the selected post: 1 for Like, 2 for Comment: ");
            actionNr = in.nextInt();
        }

        Post post = (Post) newsFeed.get(postNr - 1);
        if (actionNr == 1) {
            post.like();
            GenericDao.updateEntity(post);
            newsFeed();
        } else if (actionNr == 2) {
            post.comm();
            System.out.println("Please type your comment: ");
            String comm = in.next();
            int commId = GenericDao.count(Comment.COMM_REPOSITORY_PATH);

            Comment comment = new Comment(commId, post.getId(), comm);
            GenericDao.saveEntity(comment);
            GenericDao.updateEntity(post);
            newsFeed();
        }
    }
}

