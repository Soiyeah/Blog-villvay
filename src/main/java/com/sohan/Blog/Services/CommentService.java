package com.sohan.Blog.Services;

import com.sohan.Blog.Entities.Comment;
import com.sohan.Blog.Entities.Post;
import com.sohan.Blog.Repositories.CommentRepository;
import com.sohan.Blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {


    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment getComment(Long commentId){
        return commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException(
                "Post Id "+ commentId +"doesn't exist"));
    }

    public Iterable<Comment> getComments(){
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment editComment(Long id, Comment comment) {
        Comment commentToEdit = getComment(id);
        commentToEdit.setName(comment.getName());
        commentToEdit.setBody(comment.getBody());
        commentToEdit.setCreatedOn(comment.getCreatedOn());
        commentToEdit.setModifiedOn(comment.getCreatedOn());
        return commentToEdit;
    }

    public Comment deleteComment(Long id){
        Comment comment = getComment(id);
        commentRepository.delete(comment);
        return comment;
    }

}
