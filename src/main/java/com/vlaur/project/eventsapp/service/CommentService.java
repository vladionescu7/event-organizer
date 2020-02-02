package com.vlaur.project.eventsapp.service;

import com.vlaur.project.eventsapp.model.Comment;
import com.vlaur.project.eventsapp.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(Comment.class);

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll() {
        logger.info("finding all comments");
        return commentRepository.findAll();
    }

    public void save(Comment comment) {
        logger.info("saving comment: {}", comment);
        commentRepository.save(comment);
    }

    public void delete(Long id) {
        logger.info("deleting comment with id: {}", id);
        commentRepository.deleteById(id);
    }

    public Comment findById(long id) {
        logger.info("finding user by id");
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("comment not found"));
    }
}
