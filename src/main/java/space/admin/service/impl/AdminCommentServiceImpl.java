package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminCommentService;
import space.admin.vo.CommentVO;
import space.admin.vo.Page;
import space.dao.CommentMapper;
import space.po.Comment;

@Service("adminCommentService")
@Transactional
public class AdminCommentServiceImpl implements AdminCommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public int getTotalNumber(String retrieval) {
		return commentMapper.count(retrieval);
	}

	@Override
	public List<CommentVO> get(String retrieval, Page page) {
		List<Comment> comments = commentMapper.selectBy(retrieval, page);
		List<CommentVO> list = new ArrayList<CommentVO>();
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			list.add(new CommentVO(iterator.next()));
		}
		return list;
	}

	@Override
	public int delete(int commentId) {
		return commentMapper.deleteByPrimaryKey(commentId);
	}

}
