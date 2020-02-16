package com.vlaur.project.eventsapp.dto.comment;

import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.model.Comment;
import com.vlaur.project.eventsapp.model.Event;
import com.vlaur.project.eventsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    @Autowired
    private UserMapper userMapper;

    public Comment toEntity(CommentRequest commentRequest) {
        Comment comment = new Comment();
        Event event = new Event();
        event.setId(commentRequest.getEventId());
        User user = new User();
        user.setId(commentRequest.getEventId());
        comment.setContent(commentRequest.getContent());
        comment.setEvent(event);
        comment.setUser(user);
        return comment;
    }

    public CommentResponse toDto(Comment comment) {

        CommentResponse dto = new CommentResponse();
        dto.setContent(comment.getContent());
        dto.setId(comment.getId());
        UserResponse userResponse = userMapper.toDto(comment.getUser());
        dto.setUser(userResponse);
        return dto;
    }

    public List<CommentResponse> toDto(List<Comment> comments) {
        return comments.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
