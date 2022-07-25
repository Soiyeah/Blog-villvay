package com.sohan.Blog.Entities;

import com.sohan.Blog.Dto.AuthorDto;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Post> posts = new ArrayList<>();

    public static Author from(AuthorDto authorDto){
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setUsername(authorDto.getUsername());
        author.setEmail(authorDto.getEmail());
        author.setAddress(authorDto.getAddress());
        return author;
    }

}
