package com.sohan.Blog.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sohan.Blog.Dto.AuthorDto;
import com.sohan.Blog.Dto.CommentDto;
import com.sohan.Blog.Dto.PostDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();

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

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }


    @JsonBackReference
    public Author getAuthor(){
        return author;
    }

    @JsonManagedReference
    public List<Comment> getComments(){
        return comments;
    }

}
