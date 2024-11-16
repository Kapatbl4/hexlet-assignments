package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        return postRepository.findAll()
                .stream()
                .map(this::postToDTO)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        if (postRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }
        var post = postRepository.findById(id).get();
        PostDTO result = postToDTO(post);
        var commentList = commentRepository.findAll()
                        .stream()
                                .filter(p -> p.getPostId() == post.getId())
                                        .map(this::commentToDTO)
                                                .toList();
        result.setComments(commentList);
        return result;
    }

    private PostDTO postToDTO (Post post) {
        var postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        return postDTO;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        return commentDTO;
    }
}
// END
