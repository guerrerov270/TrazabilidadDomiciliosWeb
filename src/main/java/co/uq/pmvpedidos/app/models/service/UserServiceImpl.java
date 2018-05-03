package co.uq.pmvpedidos.app.models.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.uq.pmvpedidos.app.models.entity.User;
import co.uq.pmvpedidos.app.models.entity.Role;
import co.uq.pmvpedidos.app.models.dao.IRoleDao;
import co.uq.pmvpedidos.app.models.dao.IUserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserDao userRepository;
	@Autowired
	private IRoleDao roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
