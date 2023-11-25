package spring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}