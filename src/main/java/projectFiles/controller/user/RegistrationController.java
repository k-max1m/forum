package projectFiles.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projectFiles.entity.User;
import projectFiles.service.interfaces.UserService;
import projectFiles.service.serviceForSecurity.UserDetailServiceImpl;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @GetMapping("/registration")
    public String goToRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPage(@ModelAttribute User user, @RequestParam String repeat, ModelMap map) {
        if (repeat.equals(user.getPassword())) {
            boolean check = userDetailService.save(user);
            if (check) {
                map.put("status", "Congratulations");
                return "login";
            } else {
                map.put("status", "error");
                return "registration";
            }
        } else {
            map.put("status", "repeatPasswordError");
            return "registration";
        }
    }
}
