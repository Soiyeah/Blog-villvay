package com.sohan.Blog.Repositories;

import com.sohan.Blog.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
