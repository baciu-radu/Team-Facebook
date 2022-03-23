package com.facebook.model;

import com.facebook.dao.CommDao;
import com.facebook.dao.GenericDao;
import com.facebook.dao.PostDao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HomePage {

    int postNr = 0;

    public void newsFeed() throws IOException {
        int n = 5;
        PostDao postsDao = new PostDao();
        List<GenericEntity> newsFeed = postsDao.get(n, Post.POST_REPOSITORY_PATH);

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
        System.out.println("In order to Like Or Comment a post, please indicate first the number of the Post that you wish to Like or Comment: ");
        postNr = in.nextInt();
        if (postNr < 1 || postNr > n) {
            System.err.println("The post " + postNr + " doesn't exist. Please choose another post!\n");
            newsFeed();
        }
        addLikeOrComment();

    }

    private void addLikeOrComment() throws IOException {
        int n = 5;
        PostDao postsDao = new PostDao();
        List<GenericEntity> newsFeed = postsDao.get(n, Post.POST_REPOSITORY_PATH);

        System.out.println("Now please choose which action you want to perform for the selected post: 1 for Like, 2 for Comment: ");
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int actionNr = in.nextInt();
        while (actionNr != 1 && actionNr !=2) {
            System.err.println("Invalid action! Please try again");
            addLikeOrComment();
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
}

