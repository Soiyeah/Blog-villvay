package com.sohan.Blog.Services;

import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import com.sohan.Blog.Repositories.AuthorRepository;
import com.sohan.Blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
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

//    public Author updateAuthor(Long id, Author author) {
//
//    }

    public Post deletePost(Long id){
        Post post = getPost(id);
        postRepository.delete(post);
        return post;
    }


}
