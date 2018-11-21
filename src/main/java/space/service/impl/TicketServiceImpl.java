package space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import space.dao.TicketMapper;
import space.po.Ticket;
import space.po.User;
import space.service.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

	@Resource
	private TicketMapper tm;

	@Override
	public int save(Ticket ticket) {
		// TODO Auto-generated method stub
		return tm.insert(ticket);
	}

	@Override
	public List<Ticket> getTicketByUser(User user) {
		// TODO Auto-generated method stub
		return tm.selectByUserId(user.getUserId());
	}

	@Override
	public Ticket getTicketById(Integer tid) {
		// TODO Auto-generated method stub
		return tm.selectByPrimaryKey(tid);
	}

}
