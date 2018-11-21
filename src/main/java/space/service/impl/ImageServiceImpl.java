package space.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import space.dao.ImageMapper;
import space.po.Authentication;
import space.po.Image;
import space.service.ImageService;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper im;

	@Override
	public int save(Image img) {
		return im.insert(img);
	}

	@Override
	public List<Image> getImageByAuth(Authentication authentication) {
		// TODO Auto-generated method stub
		return im.selectByAuthenticationId(authentication.getInfId());
	}

}
