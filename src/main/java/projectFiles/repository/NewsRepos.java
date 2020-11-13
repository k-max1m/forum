package projectFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectFiles.entity.News;

public interface NewsRepos extends JpaRepository<News, Integer> {
}
