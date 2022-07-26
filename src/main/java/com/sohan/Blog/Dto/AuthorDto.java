package com.sohan.Blog.Dto;

import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
    private List<Post> posts = new ArrayList<>();

    public static AuthorDto from(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setUsername(author.getUsername());
        authorDto.setEmail(author.getEmail());
        authorDto.setAddress(author.getAddress());
        authorDto.setPosts(author.getPosts());
        return authorDto;
    }


}
