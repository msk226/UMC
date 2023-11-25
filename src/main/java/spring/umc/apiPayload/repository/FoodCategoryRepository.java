package spring.umc.apiPayload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
