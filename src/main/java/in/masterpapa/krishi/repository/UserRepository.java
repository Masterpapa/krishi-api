package in.masterpapa.krishi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.masterpapa.krishi.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

}
