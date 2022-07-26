package com.sohan.Blog.Controllers;

import com.sohan.Blog.Dto.AuthorDto;
import com.sohan.Blog.Dto.PostDto;
import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Entities.Post;
import com.sohan.Blog.Services.AuthorService;
import com.sohan.Blog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/post")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(){
        List<Post> posts = (List<Post>) postService.getPosts();
        List<PostDto> postDto = posts.stream().map(PostDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable final Long id){
        Post post = postService.getPost(id);
        return new ResponseEntity<>(PostDto.from(post),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody final PostDto postDto){
        Post post = postService.addPost(Post.from(postDto));
        return new ResponseEntity<>(PostDto.from(post), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable final Long id, @RequestBody PostDto postDto){
        Post post = postService.editPost(id,Post.from(postDto));
        return new ResponseEntity<>(PostDto.from(post), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable final Long id){
        Post post = postService.deletePost(id);
        return new ResponseEntity<>(PostDto.from(post), HttpStatus.OK);
    }

    @PostMapping(value = "{postId}/comments/{commentId}/add")
    public ResponseEntity<PostDto> addCommentToPost(@PathVariable final Long postId,
                                                     @PathVariable final Long commentId){
        Post post = postService.addCommentToPost(postId, commentId);
        return new ResponseEntity<>(PostDto.from(post), HttpStatus.OK);
    }

    @DeleteMapping(value = "{postId}/comments/{commentId}/remove")
    public ResponseEntity<PostDto> removeCommentFromPost(@PathVariable final Long postId,
                                                        @PathVariable final Long commentId){
        Post post = postService.removeCommentFromPost(postId, commentId);
        return new ResponseEntity<>(PostDto.from(post), HttpStatus.OK);
    }


}
