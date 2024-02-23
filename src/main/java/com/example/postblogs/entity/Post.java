package com.example.postblogs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Getter
    @Setter
    private String Title;
    @Getter
    @Setter
    private String Description;
    @Getter
    @Setter
    private String Body;

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Body='" + Body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(Id, post.Id) && Objects.equals(Title, post.Title) && Objects.equals(Description, post.Description) && Objects.equals(Body, post.Body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Title, Description, Body);
    }
}
