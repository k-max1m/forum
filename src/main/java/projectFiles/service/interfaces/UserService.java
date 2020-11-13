package projectFiles.service.interfaces;

import projectFiles.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAll();
}
