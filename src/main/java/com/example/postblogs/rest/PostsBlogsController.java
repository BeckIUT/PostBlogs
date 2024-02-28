package com.example.postblogs.rest;

import com.example.postblogs.entity.Post;
import com.example.postblogs.services.PostsBlogResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/posts")
public class PostsBlogsController {
    private final PostsBlogResource postsBlogResource;

    public PostsBlogsController(PostsBlogResource postsBlogResource){
        this.postsBlogResource = postsBlogResource;
    }

    @PostMapping
    public Post AddPost(@RequestBody Post post){
        return this.postsBlogResource.savePost(post);
    }

    @GetMapping("list")
    public List<Post> ListPost(){
        return this.postsBlogResource.fetchPostList();
    }

    @GetMapping("{id}")
    public Post GetPostById(@PathVariable UUID id){
        return this.postsBlogResource.fetchPostById(id);
    }

    @PutMapping("{id}")
    public Post UpdatePost(@PathVariable UUID id, @RequestBody Post post){
        return this.postsBlogResource.updatePost(post, id);
    }

    @DeleteMapping("{id}")
    public void DeletePost(@PathVariable UUID id){
        this.postsBlogResource.deletePostById(id);
    }
}
