package br.com.giulianabezerra.commentsservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {
  private final CommentRepository repository;

  public CommentController(CommentRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Comment createComment(@RequestBody Comment comment) {
    return repository.save(comment);
  }

  @GetMapping
  public List<Comment> getComments() {
    return repository.findAll();
  }
}
