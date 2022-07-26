package com.sohan.Blog.Dto;

import com.sohan.Blog.Entities.Comment;
import com.sohan.Blog.Entities.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class CommentDto {

    private Long id;
    private String name;
    private String email;
    private String body;
    private Date createdOn;
    private Date modifiedOn;
    private Post post;

    public static CommentDto from(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        commentDto.setCreatedOn(comment.getCreatedOn());
        commentDto.setModifiedOn(comment.getModifiedOn());
        commentDto.setPost(comment.getPost());
        return commentDto;
    }


}
