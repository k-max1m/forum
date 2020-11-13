package projectFiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectFiles.repository.RoleRepos;
import projectFiles.service.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepos roleRepos;

    @Override
    public String getNameRoleById(int id) {
        return roleRepos.findById(id).get().getRole();
    }
}
