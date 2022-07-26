package com.sohan.Blog.Dto;

import com.sohan.Blog.Entities.Author;
import lombok.Data;

@Data
public class PlainAuthorDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;

    public static PlainAuthorDto from(Author author) {
        PlainAuthorDto plainAuthorDto = new PlainAuthorDto();
        plainAuthorDto.setId(author.getId());
        plainAuthorDto.setName(author.getName());
        plainAuthorDto.setUsername(author.getUsername());
        plainAuthorDto.setEmail(author.getEmail());
        plainAuthorDto.setAddress(author.getAddress());
        return plainAuthorDto;
    }
}
