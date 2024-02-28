package com.example.postblogs.services;

import com.example.postblogs.entity.Post;

import java.util.List;
import java.util.UUID;

public interface PostsBlogFacade {
    // Save operation
    Post savePost(Post department);

    // Read operation
    List<Post> fetchPostList();

    Post fetchPostById(UUID id);

    // Update operation
    Post updatePost(Post post,
                                UUID postId);

    // Delete operation
    void deletePostById(UUID postId);
}
