package com.sohan.Blog.Services;

import com.sohan.Blog.Entities.Comment;
import com.sohan.Blog.Entities.Post;
import com.sohan.Blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;

    @Autowired
    public PostService(PostRepository postRepository, CommentService commentService){
        this.postRepository = postRepository;
        this.commentService = commentService;
    }


    public Post getPost(Long postId){
        return postRepository.findById(postId).orElseThrow(() -> new IllegalStateException(
                "Post Id "+ postId +"doesn't exist"));
    }

    public Iterable<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Long id, Post post) {
        Post postToEdit = getPost(id);
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        postToEdit.setCreatedOn(post.getCreatedOn());
        postToEdit.setModifiedOn(post.getCreatedOn());
        return postToEdit;
    }

    public Post deletePost(Long id){
        Post post = getPost(id);
        postRepository.delete(post);
        return post;
    }


    @Transactional
    public Post addCommentToPost(Long postId, Long commentId){
        Post post = getPost(postId);
        Comment comment = commentService.getComment(commentId);
        if(Objects.nonNull(comment.getPost())){
            throw new IllegalStateException("Error");
        }
        post.addComment(comment);
        comment.setPost(post);
        return post;
    }

    @Transactional
    public Post removeCommentFromPost(Long postId, Long commentId){
        Post post = getPost(postId);
        Comment comment = commentService.getComment(commentId);
        post.removeComment(comment);
        return post;
    }
}
