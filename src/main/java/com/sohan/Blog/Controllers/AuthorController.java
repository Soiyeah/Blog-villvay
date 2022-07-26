package com.sohan.Blog.Controllers;

import com.sohan.Blog.Dto.AuthorDto;
import com.sohan.Blog.Entities.Author;
import com.sohan.Blog.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/author")
@CrossOrigin("*")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    // Get list of all authors
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAuthors(){
        List<Author> authors = new ArrayList<>();
        authorService.getAuthors().iterator().forEachRemaining(authors::add);
        List<AuthorDto> authorsDto = authors.stream().map(AuthorDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(authorsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable final Long id){
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<>(AuthorDto.from(author),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorService.addAuthor(Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable final Long id, @RequestBody AuthorDto authorDto){
        Author author = authorService.editAuthor(id,Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable final Long id){
        Author author = authorService.deleteAuthor(id);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @PostMapping(value = "{authorId}/posts/{postId}/add")
    public ResponseEntity<AuthorDto> addPostToAuthor(@PathVariable final Long authorId,
                                                 @PathVariable final Long postId){
        Author author = authorService.addPostToAuthor(authorId, postId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @DeleteMapping(value = "{authorId}/posts/{postId}/remove")
    public ResponseEntity<AuthorDto> removeItemFromCart(@PathVariable final Long authorId,
                                                      @PathVariable final Long postId){
        Author author = authorService.removePostFromAuthor(authorId, postId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

}
