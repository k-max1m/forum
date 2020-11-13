package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFiles.entity.Role;

public interface RoleRepos extends JpaRepository<Role, Integer> {
}
