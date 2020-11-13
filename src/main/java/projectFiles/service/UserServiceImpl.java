package projectFiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectFiles.entity.User;
import projectFiles.repository.UserRepos;
import projectFiles.service.interfaces.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepos userRepos;
    @Override
    public User addUser(User user) {
        userRepos.save(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepos.findAll();
    }
}
