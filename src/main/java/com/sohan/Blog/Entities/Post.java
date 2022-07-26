package com.sohan.Blog.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sohan.Blog.Dto.AuthorDto;
import com.sohan.Blog.Dto.PostDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    @ManyToOne
    private Author author;
    private Date createdOn;
    private Date modifiedOn;

    public static Post from(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setAuthor(postDto.getAuthor());
        post.setCreatedOn(postDto.getCreatedOn());
        post.setModifiedOn(postDto.getModifiedOn());
        return post;
    }

    @JsonBackReference
    public Author getAuthor(){
        return author;
    }

}
