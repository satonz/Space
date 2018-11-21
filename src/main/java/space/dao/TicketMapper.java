package space.dao;

import java.util.List;

import space.po.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer ticketId);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer ticketId);
    
    List<Ticket> selectByActivityId(Integer activityId);
    
    List<Ticket> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

}