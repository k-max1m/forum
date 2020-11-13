package projectFiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import projectFiles.entity.User;
import projectFiles.repository.UserRepos;

@Controller
public class MainController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/")
    public String loginPage1() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/main")
    public String mainPage(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepos.findByLogin(authentication.getName());
        map.put("user", user.getFirstName() + " " + user.getLastName() + "!");
        return "admin/admin_home";
    }
}
