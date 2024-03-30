package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Comment;
import java.util.List;

public interface ICommentService {
    Comment addCommentToPost(Long postId, Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
}
