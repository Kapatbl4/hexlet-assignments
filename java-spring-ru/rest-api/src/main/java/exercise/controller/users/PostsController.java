package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;


import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private static List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> usersPostsIndex(@PathVariable int id) {
        List<Post> userPosts = posts
                .stream()
                .filter(p -> p.getUserId() == id)
                .toList();
        return userPosts;
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost (@PathVariable int id, @RequestBody Post data) {
        Post post = new Post();
        post.setUserId(id);
        post.setSlug(data.getSlug());
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        posts.add(post);

        return post;
    }
}
// END
