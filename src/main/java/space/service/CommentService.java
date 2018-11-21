package space.service;

import space.po.Comment;

public interface CommentService {
	int save(Comment comment);
	
	Comment getCommentById(int id);
}
