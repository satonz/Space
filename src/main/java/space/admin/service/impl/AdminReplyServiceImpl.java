package space.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminReplyService;
import space.admin.vo.Page;
import space.admin.vo.ReplyVO;
import space.dao.ReplyMapper;
import space.po.Reply;

@Service("adminReplyService")
@Transactional
public class AdminReplyServiceImpl implements AdminReplyService {

	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public int getTotalNumber(String retrieval) {
		return replyMapper.count(retrieval);
	}

	@Override
	public List<ReplyVO> get(String retrieval, Page page) {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		List<Reply> replies = replyMapper.selectBy(retrieval, page);
		Iterator<Reply> iterator = replies.iterator();
		while (iterator.hasNext()) {
			list.add(new ReplyVO(iterator.next()));
		}
		return list;
	}

	@Override
	public int delete(int replyId) {
		return replyMapper.deleteByPrimaryKey(replyId);
	}

}
