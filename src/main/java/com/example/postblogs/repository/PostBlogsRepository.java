package com.example.postblogs.repository;

import com.example.postblogs.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostBlogsRepository extends CrudRepository<Post, UUID> {
}
