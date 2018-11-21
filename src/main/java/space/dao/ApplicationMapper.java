package space.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import space.admin.vo.Page;
import space.po.Application;

public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer appId);
    
    List<Application> selectByRoomId(Integer roomId);
    
    List<Application> selectByUserId(Integer userId);
    
    /**
     * 获取未来第n天通过的申请信息(n>=0)
     * @param status
     * @param deal
     * @return
     */
    List<Application> selectApplicationsIntNDays(@Param("day")int day, @Param("status")boolean status, @Param("deal")boolean deal);
    
    /**
     * 根据建筑类型、申请状态以及处理状态获取记录总数
     * @param buildingType 
     * @param status
     * @param deal
     * @return
     */
    int countByBuildingTypeStatusDealRetrieval(@Param("buildingType")int buildingType, @Param("status")boolean status, @Param("deal")boolean deal, @Param("retrieval")String retrieval);
    
    /**
     * 查询申请地点为roomId并且使用时间段在startTime和endTime之间的通过申请
     * @param roomId
     * @param startTime 开始使用时间
     * @param endTime 结束使用时间
     * @return 
     */
    int countByRoomIdAndAppUserTime(@Param("roomId")int roomId, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
    
    int count(@Param("retrieval")String retrieval, @Param("status")boolean status, @Param("deal")boolean deal);
    
    List<Application> selectBy(@Param("buildingType")int buildingType, @Param("retrieval")String retrieval, @Param("status")boolean status, @Param("deal")boolean deal, @Param("page")Page page);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKeyWithBLOBs(Application record);

    int updateByPrimaryKey(Application record);

	List<Application> checkTimeConflict(Application application);

}