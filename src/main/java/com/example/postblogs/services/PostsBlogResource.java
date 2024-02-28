package com.example.postblogs.services;

import com.example.postblogs.entity.Post;
import com.example.postblogs.repository.PostBlogsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class PostsBlogResource
        implements PostsBlogFacade {
    private final PostBlogsRepository postBlogsRepository;

    public PostsBlogResource(PostBlogsRepository postBlogsRepository){
        this.postBlogsRepository = postBlogsRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postBlogsRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {
        return (List<Post>) postBlogsRepository.findAll();
    }

    @Override
    public Post fetchPostById(UUID id) {
        Post post = this.postBlogsRepository.findById(id).get();
        if(Objects.isNull(post)){
            throw new NoSuchElementException("No such element in Database");
        }
        return post;
    }

    @Override
    public Post updatePost(Post post, UUID postId) {
        Post dbPost = postBlogsRepository.findById(postId).get();

        if(Objects.isNull(dbPost)){
            throw new NoSuchElementException("No such element in Database");
        }

        if(Objects.nonNull(dbPost.getBody()) &&
        !"".equalsIgnoreCase(dbPost.getBody())){
            dbPost.setBody(post.getBody());
        }

        if(Objects.nonNull(dbPost.getTitle()) &&
                !"".equalsIgnoreCase(dbPost.getTitle())){
            dbPost.setTitle(post.getTitle());
        }

        if(Objects.nonNull(dbPost.getDescription()) &&
                !"".equalsIgnoreCase(dbPost.getDescription())){
            dbPost.setDescription(post.getDescription());
        }

        return postBlogsRepository.save(dbPost);
    }

    @Override
    public void deletePostById(UUID postId) {
        Post dbPost = postBlogsRepository.findById(postId).get();

        if(Objects.isNull(dbPost)){
            throw new NoSuchElementException("No such element in Database");
        }

        postBlogsRepository.deleteById(postId);
    }
}
