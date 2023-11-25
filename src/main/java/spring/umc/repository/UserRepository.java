package spring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
