package space.service;

import java.util.List;

import space.po.Ticket;
import space.po.User;

public interface TicketService {

	int save(Ticket ticket);

	List<Ticket> getTicketByUser(User loginUser);

	Ticket getTicketById(Integer tid);
}
