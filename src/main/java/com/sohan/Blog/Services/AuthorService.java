package com.sohan.Blog.Services;

import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import com.sohan.Blog.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final PostService postService;


    @Autowired
    public AuthorService(AuthorRepository authorRepository, PostService postService){
        this.authorRepository = authorRepository;
        this.postService = postService;
    }

    public Author getAuthor(Long authorId){
        return authorRepository.findById(authorId).orElseThrow(() -> new IllegalStateException(
                "Auther Id "+ authorId +"doesn't exist"));
    }

    public Iterable<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author editAuthor(Long id, Author author) {
        Author authorToEdit = getAuthor(id);
        authorToEdit.setName(author.getName());
        authorToEdit.setUsername(author.getUsername());
        authorToEdit.setEmail(author.getEmail());
        authorToEdit.setAddress(author.getAddress());
        return authorToEdit;
    }

    public Author deleteAuthor(Long id){
        Author author = getAuthor(id);
        authorRepository.delete(author);
        return author;
    }

    @Transactional
    public Author addPostToAuthor(Long authorId, Long postId){
        Author author = getAuthor(authorId);
        Post post = postService.getPost(postId);
        if(Objects.nonNull(post.getAuthor())){
            throw new IllegalStateException("Error");
        }
        author.addPost(post);
        post.setAuthor(author);
        return author;
    }

    @Transactional
    public Author removePostFromAuthor(Long authorId, Long postId){
        Author author = getAuthor(authorId);
        Post post = postService.getPost(postId);
        author.removePost(post);
        return author;
    }

}
