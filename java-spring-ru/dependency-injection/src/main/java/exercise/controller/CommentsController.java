package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable long id) {
        if (commentRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Комментарий не существует");
        }
        return commentRepository.findById(id).get();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping(path = "/{id}")
    public Comment update(@PathVariable long id, @RequestBody Comment data) {
        if (commentRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Комментарий не существует");
        }
        Comment comment = commentRepository.findById(id).get();
        comment.setBody(data.getBody());
        return comment;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable long id) {
        if (commentRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Комментарий не существует");
        }
        commentRepository.deleteById(id);
    }
}
// END
