package space.admin.vo;

/**
 * 统计信息
 * 
 */
public class StatisticalInformation {

	private int studentAuthentication;// 学生认证申请人数
	private int teacherAuthentication;// 老师认证申请人数
	private int clubAuthentication;// 社团认证申请人数
	private int collegeAuthentication;// 学院认证申请人数

	private int claApplications;// 教室申请数
	private int labApplications;// 实验室申请数
	private int comApplication;// 综合楼申请数

	private int message;// 留言数

	private int historyVisitors;// 历史访问人数
	private int todayVisitors;// 今天访问人数

	public int getStudentAuthentication() {
		return studentAuthentication;
	}

	public void setStudentAuthentication(int studentAuthentication) {
		this.studentAuthentication = studentAuthentication;
	}

	public int getTeacherAuthentication() {
		return teacherAuthentication;
	}

	public void setTeacherAuthentication(int teacherAuthentication) {
		this.teacherAuthentication = teacherAuthentication;
	}

	public int getClubAuthentication() {
		return clubAuthentication;
	}

	public void setClubAuthentication(int clubAuthentication) {
		this.clubAuthentication = clubAuthentication;
	}

	public int getCollegeAuthentication() {
		return collegeAuthentication;
	}

	public void setCollegeAuthentication(int collegeAuthentication) {
		this.collegeAuthentication = collegeAuthentication;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public int getHistoryVisitors() {
		return historyVisitors;
	}

	public void setHistoryVisitors(int historyVisitors) {
		this.historyVisitors = historyVisitors;
	}

	public int getTodayVisitors() {
		return todayVisitors;
	}

	public void setTodayVisitors(int todayVisitors) {
		this.todayVisitors = todayVisitors;
	}

	public StatisticalInformation() {
		// TODO Auto-generated constructor stub
	}

	public StatisticalInformation(int studentAuthentication, int teacherAuthentication, int clubAuthentication,
			int collegeAuthentication, int classRoomApplications, int labApplications, int complexBuildingApplications,
			int message, int historyVisitors, int todayVisitors) {
		super();
		this.studentAuthentication = studentAuthentication;
		this.teacherAuthentication = teacherAuthentication;
		this.clubAuthentication = clubAuthentication;
		this.collegeAuthentication = collegeAuthentication;
		this.claApplications = classRoomApplications;
		this.labApplications = labApplications;
		this.comApplication = complexBuildingApplications;
		this.message = message;
		this.historyVisitors = historyVisitors;
		this.todayVisitors = todayVisitors;
	}

	public int getClaApplications() {
		return claApplications;
	}

	public void setClaApplications(int claApplications) {
		this.claApplications = claApplications;
	}

	public int getLabApplications() {
		return labApplications;
	}

	public void setLabApplications(int labApplications) {
		this.labApplications = labApplications;
	}

	public int getComApplication() {
		return comApplication;
	}

	public void setComApplication(int comApplication) {
		this.comApplication = comApplication;
	}

}
