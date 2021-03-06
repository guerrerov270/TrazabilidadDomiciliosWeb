package co.uq.pmvpedidos.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.uq.pmvpedidos.app.models.entity.User;

@Repository("userRepository")
public interface IUserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
