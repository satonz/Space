package space.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import space.dao.CommentMapper;
import space.po.Comment;
import space.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper cm;

	@Override
	public int save(Comment comment) {
		return cm.insert(comment);
	}

	@Override
	public Comment getCommentById(int id) {
		
		return cm.selectByPrimaryKey(id);
	}

}
