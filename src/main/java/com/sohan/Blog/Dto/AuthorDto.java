package com.sohan.Blog.Dto;

import com.sohan.Blog.Entities.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;

    public static AuthorDto from(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setUsername(author.getUsername());
        authorDto.setEmail(author.getEmail());
        authorDto.setAddress(author.getAddress());
        return authorDto;
    }


}
