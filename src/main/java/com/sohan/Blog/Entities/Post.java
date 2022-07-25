package com.sohan.Blog.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private Long id;
    private String title;
    private String body;
    private Author author;
    private Date createdOn;
    private Date modifiedOn;


}
