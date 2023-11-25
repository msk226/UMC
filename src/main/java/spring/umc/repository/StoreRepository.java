package spring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
