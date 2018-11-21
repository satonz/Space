package space.service;

import java.util.List;

import space.po.Authentication;
import space.po.Image;

public interface ImageService {

	int save(Image img);

	List<Image> getImageByAuth(Authentication authentication);

}
