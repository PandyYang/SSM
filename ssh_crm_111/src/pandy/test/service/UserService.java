package pandy.test.service;

import pandy.test.domain.User;

public interface UserService {
	User getUserByCodePassword(User u);
	void saveUser(User u);
}
