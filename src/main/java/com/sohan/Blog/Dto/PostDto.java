package com.sohan.Blog.Dto;

import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String body;
    private Author author;
    private Date createdOn;
    private Date modifiedOn;

    public static PostDto from(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setBody(post.getBody());
        postDto.setAuthor(post.getAuthor());
        postDto.setCreatedOn(post.getCreatedOn());
        postDto.setModifiedOn(post.getModifiedOn());
        return postDto;
    }


}
