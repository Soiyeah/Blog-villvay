package com.sohan.Blog.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sohan.Blog.Dto.CommentDto;
import com.sohan.Blog.Dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String body;
    @ManyToOne
    private Post post;
    private Date createdOn;
    private Date modifiedOn;

    public static Comment from(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        comment.setCreatedOn(commentDto.getCreatedOn());
        comment.setModifiedOn(commentDto.getModifiedOn());
        comment.setPost(commentDto.getPost());
        return comment;
    }

    @JsonBackReference
    public Post getPost(){
        return post;
    }

}
