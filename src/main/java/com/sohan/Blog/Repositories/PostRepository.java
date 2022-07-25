package com.sohan.Blog.Repositories;

import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
