package repositories;

import dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByEmail(String email);
}
