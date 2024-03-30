package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.entity.Comment;
import com.trendtalk.app.repository.entity.Post;
import com.trendtalk.app.repository.interfaces.IComment;
import com.trendtalk.app.repository.interfaces.IPost;
import com.trendtalk.app.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {

    private final IComment commentRepository;
    private final IPost postRepository; // Post repository'yi enjekte etmek için

    @Autowired
    public CommentServiceImpl(IComment commentRepository, IPost postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment addCommentToPost(Long postId, Comment comment) {
        // Post nesnesini bul ve comment ile ilişkilendir
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new RuntimeException("Post not found with id " + postId));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment updateComment(Long id, Comment commentDetails) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setContent(commentDetails.getContent());
                    // Burada yorum güncellemesi için diğer alanlar da set edilebilir.
                    return commentRepository.save(comment);
                }).orElseThrow(() -> new RuntimeException("Comment not found with id " + id));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
