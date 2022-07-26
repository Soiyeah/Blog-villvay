package com.sohan.Blog.Repositories;

import com.sohan.Blog.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
