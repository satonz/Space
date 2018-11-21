package space.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.ReplyMapper;
import space.po.Reply;
import space.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{

	@Resource
	private ReplyMapper rm;

	@Override
	public int save(Reply reply) {
		// TODO Auto-generated method stub
		return rm.insert(reply);
	}
}
