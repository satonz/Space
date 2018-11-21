package space.po;

public class Image {
	private Integer imgId;

	private String imgPath;

	/*
	 * 照片所属的认证表，一个认证表可以有多个照片
	 */
	private Authentication authentication;

	public Image() {
		super();
	}

	public Image(String imgPath, Authentication authentication) {
		super();
		this.imgPath = imgPath;
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "Image [imgPath=" + imgPath + ", authentication=" + authentication + "]";
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath == null ? null : imgPath.trim();
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
}