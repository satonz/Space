package space.admin.vo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

/**
 * 操作系统及服务器相关信息
 * 
 */
public class SystemInformation {

	// 操作系统相关信息
	private String osName; // 操作系统名称
	private String osVersion; // 操作系统版本
	private Date osTime; // 操作系统当前时间
	private String javaVersion; // java版本
	private String sunDesktop;// java平台
	private String osIp;// 操作系统IP(服务器运行IP)

	// 服务器相关信息
	private String serverName; // 服务器名称
	private Integer serverPort; // 服务器开放端口
	private String serverHost; // 客户端IP
	private String serverProtocol;// 服务器协议

	private void init() {
		Properties props = System.getProperties();
		osName = props.getProperty("os.name");
		osVersion = props.getProperty("os.version");
		osTime = new Date();
		javaVersion = props.getProperty("java.version");
		sunDesktop = props.getProperty("sun.desktop");
		try {
			InetAddress address = InetAddress.getLocalHost();
			osIp = address.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	public SystemInformation(HttpServletRequest request) {
		// 初始化服务器相关信息
		serverName = request.getServerName();
		serverPort = request.getServerPort();
		serverHost = getIp(request);
		serverProtocol = request.getProtocol();
		// 初始化操作系统相关信息
		init();
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public Date getOsTime() {
		return osTime;
	}

	public void setOsTime(Date osTime) {
		this.osTime = osTime;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getSunDesktop() {
		return sunDesktop;
	}

	public void setSunDesktop(String sunDesktop) {
		this.sunDesktop = sunDesktop;
	}

	public String getOsIp() {
		return osIp;
	}

	public void setOsIp(String osIp) {
		this.osIp = osIp;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getServerProtocol() {
		return serverProtocol;
	}

	public void setServerProtocol(String serverProtocol) {
		this.serverProtocol = serverProtocol;
	}

}
