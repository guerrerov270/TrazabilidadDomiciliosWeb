package co.uq.pmvpedidos.app.models.service;

import co.uq.pmvpedidos.app.models.entity.User;

public interface UserService {
	public User findUserByEmail(String email);

	public void saveUser(User user);
}
