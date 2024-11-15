package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Post show(@PathVariable long id) {
        if (postRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }
        return postRepository.findById(id).get();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping(path = "/{id}")
    public Post update(@RequestBody Post data, @PathVariable long id) {
        if (postRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }
        Post post = postRepository.findById(id).get();
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable long id) {
        if (postRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }
        postRepository.deleteById(id);
        commentRepository.deleteByPostId(id);
    }
}
// END
