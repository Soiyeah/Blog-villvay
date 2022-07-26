package com.sohan.Blog.Controllers;

import com.sohan.Blog.Dto.CommentDto;
import com.sohan.Blog.Entities.Comment;
import com.sohan.Blog.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/comment")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments(){
        List<Comment> comments = (List<Comment>) commentService.getComments();
        List<CommentDto> commentDto = comments.stream().map(CommentDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable final Long id){
        Comment comment = commentService.getComment(id);
        return new ResponseEntity<>(CommentDto.from(comment),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody final CommentDto commentDto){
        Comment comment = commentService.addComment(Comment.from(commentDto));
        return new ResponseEntity<>(CommentDto.from(comment), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CommentDto> updatePost(@PathVariable final Long id, @RequestBody CommentDto commentDto){
        Comment comment = commentService.editComment(id,Comment.from(commentDto));
        return new ResponseEntity<>(CommentDto.from(comment), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CommentDto> deletePost(@PathVariable final Long id){
        Comment comment = commentService.deleteComment(id);
        return new ResponseEntity<>(CommentDto.from(comment), HttpStatus.OK);
    }


}
