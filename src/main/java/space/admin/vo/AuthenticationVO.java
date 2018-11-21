package space.admin.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import space.po.Authentication;
import space.po.Image;

public class AuthenticationVO {

	private int id;
	private String account;
	private String name;
	private List<String> images = new ArrayList<String>();
	private String introduce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public AuthenticationVO() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationVO(int id, String account, String name, List<String> images, String introduce, Date time) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.images = images;
		this.introduce = introduce;
	}

	public AuthenticationVO(Authentication authentication) {
		id = authentication.getInfId();
		account = authentication.getUser().getEmail();
		name = authentication.getInfName();
		List<Image> is = authentication.getImages();
		Iterator<Image> iterator = is.iterator();
		while (iterator.hasNext()) {
			Image i = iterator.next();
			images.add(i.getImgPath());
		}
		introduce = authentication.getInfIntroduce();
	}

}
