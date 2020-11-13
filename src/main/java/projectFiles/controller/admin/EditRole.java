package projectFiles.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import projectFiles.entity.User;
import projectFiles.service.interfaces.RoleService;
import projectFiles.service.interfaces.UserService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class EditRole {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/edit")
    public String editRoleLogin(ModelMap map) {
        Map<String, String> loginAndRole = userService.getAll().stream()
                .collect(Collectors.toMap(User::getLogin, o -> roleService.getNameRoleById(o.getRoleId())));
        List<String> collect = userService.getAll().stream().map(User::getLogin).collect(Collectors.toList());
        map.put("users", collect);
        List<String> roles = Arrays.asList("ADMIN", "USER");
        map.put("roles", roles);
        return "admin/editRole";
    }

    @PostMapping("/editRole")
    public String editUser(@ModelAttribute List<String> user, @ModelAttribute List<String> role) {
        System.out.println(user);
        System.out.println(role);
        return "redirect:/edit";

    }
}
