package space.service;

import space.po.Profile;
import space.po.User;

public interface ProfileService {

	int save(Profile profile);

	Profile selectByUser(User user);

	int update(Profile profile);
}
