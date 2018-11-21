package space.admin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import space.admin.service.AdminActivityService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:Application.xml"}) 
public class JUnit4Test {
	
	@Test
	public void testBuildingService() {
//		Byte buiType = 1;
//		String buiName = "6B";
//		String buiIntroduce = "综合楼";
//		Building building = new Building(buiName, buiType, buiIntroduce);
//		buildingService.save(building);
	}
	
	@Autowired
	private AdminActivityService adminActivityService;
	@Test
	public void testAdminActivityService(){
		adminActivityService.getTotalNumber("");
	}
}
