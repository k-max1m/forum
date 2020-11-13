package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFiles.entity.User;

public interface UserRepos extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
